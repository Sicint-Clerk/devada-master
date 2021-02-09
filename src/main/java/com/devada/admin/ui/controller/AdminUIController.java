package com.devada.admin.ui.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devada.admin.api.dao.MainCategoryDao;
import com.devada.admin.api.entity.Contact;
import com.devada.admin.api.entity.DBFile;
import com.devada.admin.api.entity.FamilyInformation;
import com.devada.admin.api.entity.MainCategory;
import com.devada.admin.api.entity.MarriageInfoDto;
import com.devada.admin.api.entity.MarriageInformation;
import com.devada.admin.api.entity.MarriedDaughter;
import com.devada.admin.api.entity.PersonInfoDto;
import com.devada.admin.api.entity.PersonInformation;
import com.devada.admin.api.entity.SubCategory;
import com.devada.admin.api.entity.UploadImage;
import com.devada.admin.api.repository.AdminRepository;
import com.devada.admin.constants.AdminUiConstants;
import com.devada.admin.ui.dto.LoginUiDto;
import com.devada.base.controller.BaseController;
import com.devada.base.dto.ReturnMessageDto;
import com.devada.base.exception.KKDaoException;
import com.google.gson.Gson;

@Controller
@RequestMapping(AdminUiConstants.ADMIN)

// @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
// maxFileSize = 1024 * 1024 * 50, // 50 MB
// maxRequestSize = 1024 * 1024 * 100)
public class AdminUIController extends BaseController {

	@Autowired
	private AdminRepository adminRepository;
	private MainCategoryDao mainCategoryDao;

	/*
	 * @Autowired private CommonUtility commonUtility;
	 */

	@RequestMapping("")
	public ModelAndView loadDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/admin/login");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody String login(@RequestBody LoginUiDto loginUiDto, HttpSession session) {
		String user = "false";
		try {
			if ("null".equalsIgnoreCase(loginUiDto.getUserName()) || !"".equals(loginUiDto.getUserName().trim())
					|| "null".equalsIgnoreCase(loginUiDto.getPassword())
					|| !"".equals(loginUiDto.getPassword().trim())) {

				PersonInformation personInformations = adminRepository.validateUser(loginUiDto);
				if (null != personInformations && "admin".equalsIgnoreCase(personInformations.getRole())) {
					user = "admin";
					session.setAttribute("loginUserRole", user);
					session.setAttribute("loginUserName", "admin");
					session.setAttribute("loginUsrEmailId", personInformations.getEmail());
				} else if (null != personInformations && "guser".equalsIgnoreCase(personInformations.getRole())) {
					user = "guser";
					session.setAttribute("loginUserRole", user);
					session.setAttribute("loginUserName", personInformations.getName());
				} else {
					user = "false";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(user);
	}

	@RequestMapping("/loadList")
	public ModelAndView loadProductPage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (isValidSession(session)) {
				if ("admin".equalsIgnoreCase((String) session.getAttribute("loginUserRole"))) {
					List<PersonInformation> personInformations = adminRepository.getPersonInformation();
					modelAndView.addObject("personInformations", personInformations);
					modelAndView.setViewName("jsp/admin/form");
				} else {
					return getApprovedList(session);
				}
			} else {
				modelAndView.setViewName("jsp/admin/login");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(AdminUiConstants.SAVE)
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody ReturnMessageDto savePersonInfo(@RequestBody PersonInfoDto personInfoDto) {
		ReturnMessageDto messageDto = new ReturnMessageDto();
		try {
			PersonInformation personInformation = adminRepository
					.savePersonInformation(personInfoDto.getPersonInformation());
			for (FamilyInformation familyInformation : personInfoDto.getFamilyInformations()) {
				if (null != familyInformation && StringUtils.isNotBlank(familyInformation.getMemberName())) {
					familyInformation.setPersonKey(personInformation.getId());
					adminRepository.saveFamilyInformation(familyInformation);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageDto;
	}

	@RequestMapping(AdminUiConstants.UPDATE)
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody ReturnMessageDto updateCategory(@RequestBody PersonInformation personInformation) {
		ReturnMessageDto messageDto = new ReturnMessageDto();
		try {
			adminRepository.savePersonInformation(personInformation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageDto;
	}

	@RequestMapping(AdminUiConstants.APPROVED)
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody ReturnMessageDto approvedInformation(@RequestBody PersonInformation personInformation) {
		ReturnMessageDto messageDto = new ReturnMessageDto();
		try {
			PersonInformation information = adminRepository.getInformationByKey(personInformation.getId());
			information.setIsApproved(personInformation.getIsApproved());
			adminRepository.updatePersonInformation(information);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageDto;
	}

	@RequestMapping("saveContact")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody ModelAndView saveContact(@RequestBody Contact contact) {
		try {
			adminRepository.saveContact(contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsp/frontend/index");
		return modelAndView;
	}

	@RequestMapping(value = "/viewProfile/{id}")
	public ModelAndView viewProfile(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			PersonInformation personInformation = adminRepository.getInformationByKey(id);
			List<FamilyInformation> familyInfoList = adminRepository
					.getFamilyInformationByPersonKey(personInformation.getId());

			modelAndView.addObject("personInformations", personInformation);
			modelAndView.addObject("familyInfo", familyInfoList);
			modelAndView.setViewName("jsp/ViewRegistration");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/loadApprovedList")
	public ModelAndView getApprovedList(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (isValidSession(session)) {
				List<PersonInformation> personInformations = adminRepository.getApprovedList();
				modelAndView.addObject("personInformations", personInformations);
				modelAndView.setViewName("jsp/admin/ApprovedListPage");
			} else {
				modelAndView.setViewName("jsp/admin/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping("/exportData")
	public void exportData(HttpServletResponse response) throws IOException, KKDaoException {
		List<PersonInformation> personInformations = adminRepository.getApprovedList();
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Approved Data");
		sheet.setColumnWidth(0, 7000);
		for (int i = 1; i <= 12; i++) {
			sheet.setColumnWidth(i, 4000);
		}

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.RED.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);

		// Create a Font for styling header cells
		Font familyFont = workbook.createFont();
		familyFont.setBold(true);
		familyFont.setFontHeightInPoints((short) 11);
		familyFont.setColor(IndexedColors.RED1.getIndex());

		// Create a CellStyle with the font
		CellStyle familyFontCellStyle = workbook.createCellStyle();
		familyFontCellStyle.setFont(familyFont);

		CellStyle style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BROWN.getIndex());

		// Create Other rows and cells with employees data
		int rowNum = 0;
		for (PersonInformation personInformation : personInformations) {
			Row header = sheet.createRow(rowNum++);
			header.createCell(0).setCellValue("Main person's name");
			header.createCell(1).setCellValue("Birth date");
			header.createCell(2).setCellValue("Father's name");
			header.createCell(3).setCellValue("Mother's name");
			header.createCell(4).setCellValue("Mosan");
			header.createCell(5).setCellValue("Current address");
			header.createCell(6).setCellValue("Phone number");
			header.createCell(7).setCellValue("Mobile number");
			header.createCell(8).setCellValue("Education");
			header.createCell(9).setCellValue("Blood group");
			header.createCell(10).setCellValue("Job/Business");
			header.createCell(11).setCellValue("Address");
			header.createCell(12).setCellValue("Vas");
			for (int i = 0; i <= 12; i++) {
				header.getCell(i).setCellStyle(headerCellStyle);
			}

			Row data = sheet.createRow(rowNum++);
			data.createCell(0).setCellValue(personInformation.getName());
			data.createCell(1).setCellValue(personInformation.getBirthDate());
			data.createCell(2).setCellValue(personInformation.getFatherName());
			data.createCell(3).setCellValue(personInformation.getMotherName());
			data.createCell(4).setCellValue(personInformation.getMosan());
			data.createCell(5).setCellValue(personInformation.getPresentAddress());
			data.createCell(6).setCellValue(personInformation.getPhone());
			data.createCell(7).setCellValue(personInformation.getMobile());
			data.createCell(8).setCellValue(personInformation.getEducation());
			data.createCell(9).setCellValue(personInformation.getBloodGroup());
			data.createCell(10).setCellValue(personInformation.getWork());
			data.createCell(11).setCellValue(personInformation.getPermanentAddress());
			data.createCell(12).setCellValue(personInformation.getVas());

			List<FamilyInformation> familyInfoList = adminRepository
					.getFamilyInformationByPersonKey(personInformation.getId());

			Row familyHeader = sheet.createRow(rowNum++);
			familyHeader.createCell(0).setCellValue("Family member's name");
			familyHeader.createCell(1).setCellValue("Age");
			familyHeader.createCell(2).setCellValue("Relation");
			familyHeader.createCell(3).setCellValue("Education");
			familyHeader.createCell(4).setCellValue("Profession");
			familyHeader.createCell(5).setCellValue("Married");
			familyHeader.createCell(6).setCellValue("Blood Group");
			for (int i = 0; i <= 6; i++) {
				familyHeader.getCell(i).setCellStyle(familyFontCellStyle);
			}

			for (FamilyInformation familyInformation : familyInfoList) {
				Row family = sheet.createRow(rowNum++);
				family.createCell(0).setCellValue(familyInformation.getMemberName());
				family.createCell(1).setCellValue(familyInformation.getAge());
				family.createCell(2).setCellValue(familyInformation.getRelation());
				family.createCell(3).setCellValue(familyInformation.getEducation());
				family.createCell(4).setCellValue(familyInformation.getProfession());
				if (familyInformation.getMarried().equalsIgnoreCase("Y")) {
					family.createCell(5).setCellValue("Yes");
				} else {
					family.createCell(5).setCellValue("No");
				}
				family.createCell(6).setCellValue(familyInformation.getBloodGroup());
			}
			sheet.createRow(rowNum++);
		}

		// Write the output to a file
		FileOutputStream out = new FileOutputStream(new File("data/new.xlsx"));
		workbook.write(out);
		out.close();
		workbook.close();
		File file = new File("data/new.xlsx");

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		int bytesRead;
		byte[] buf = new byte[2048];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((bytesRead = bis.read(buf)) != -1) {
			baos.write(buf, 0, bytesRead);
		}
		bis.close();
		fis.close();
		baos.flush();
		baos.close();

		response.setContentType("application/x-www-form-urlencoded");
		response.setHeader("Content-Disposition", "attachment; filename=ApprovedData.xlsx");

		ServletOutputStream sos = response.getOutputStream();
		sos.write(baos.toByteArray());
		sos.flush();
		sos.close();

		file.delete();
	}

	@PostMapping(value = "/uploadExcelFile")
	public ModelAndView importData(@RequestParam("file") MultipartFile multipartFile,
			RedirectAttributes redirectAttributes) throws IOException, KKDaoException, InvalidFormatException {
		if (multipartFile.isEmpty()) {
			return new ModelAndView("status", "message", "Please select a file and try again");
		}

		try {
			byte[] bytes = multipartFile.getBytes();
			String url = ResourceUtils.getFile("classpath:").getPath() + new Date().getTime()
					+ multipartFile.getOriginalFilename();
			Path path = Paths.get(url);
			Files.write(path, bytes);
			boolean status = false;
			int mainperson = 0;
			int family = 0;

			List<FamilyInformation> familyInformations = new ArrayList<>();
			PersonInformation information = new PersonInformation();
			FamilyInformation familyInformation = new FamilyInformation();

			File file = new File(url);
			Workbook workbook = WorkbookFactory.create(file);
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
				Iterator<Row> rows = sheet.rowIterator();
				while (rows.hasNext()) {
					Row row = rows.next();
					if (null != row.getCell(0)
							&& row.getCell(0).getStringCellValue().equalsIgnoreCase("Main person's name")) {
						mainperson = mainperson + 1;
					}
					if (mainperson == 1 && family == 0 && StringUtils.isNoneBlank(row.getCell(0).getStringCellValue())
							&& !row.getCell(0).getStringCellValue().equalsIgnoreCase("Main person's name")
							&& !row.getCell(0).getStringCellValue().equalsIgnoreCase("Family member's name")) {
						if (null != row.getCell(0)) {
							information.setName(row.getCell(0).getStringCellValue());
						}
						if (null != row.getCell(1)) {
							information.setBirthDate(row.getCell(1).getStringCellValue());
						}
						if (null != row.getCell(2)) {
							information.setFatherName(row.getCell(2).getStringCellValue());
						}
						if (null != row.getCell(3)) {
							information.setMotherName(row.getCell(3).getStringCellValue());
						}
						if (null != row.getCell(4)) {
							information.setMosan(row.getCell(4).getStringCellValue());
						}

						if (null != row.getCell(5)) {
							information.setPresentAddress(row.getCell(5).getStringCellValue());
						}
						if (null != row.getCell(6)) {
							information.setPhone(row.getCell(6).getStringCellValue());
						}
						if (null != row.getCell(7)) {
							information.setMobile(row.getCell(7).getStringCellValue());
						}
						if (null != row.getCell(8)) {
							information.setEducation(row.getCell(8).getStringCellValue());
						}
						if (null != row.getCell(9)) {
							information.setBloodGroup(row.getCell(9).getStringCellValue());
						}
						if (null != row.getCell(10)) {
							information.setWork(row.getCell(10).getStringCellValue());
						}
						if (null != row.getCell(11)) {
							information.setPermanentAddress(row.getCell(11).getStringCellValue());
						}
						if (null != row.getCell(12)) {
							information.setVas(row.getCell(12).getStringCellValue());
						}
					}
					if (null != row.getCell(0)
							&& row.getCell(0).getStringCellValue().equalsIgnoreCase("Family member's name")) {
						family = family + 1;
					}
					if (family == 1 && StringUtils.isNoneBlank(row.getCell(0).getStringCellValue())
							&& !row.getCell(0).getStringCellValue().equalsIgnoreCase("Family member's name")
							&& !row.getCell(0).getStringCellValue().equalsIgnoreCase("Main person's name")) {
						familyInformation = new FamilyInformation();
						if (null != row.getCell(0)) {
							familyInformation.setMemberName(row.getCell(0).getStringCellValue());
						}
						if (null != row.getCell(1)) {
							familyInformation.setAge(row.getCell(1).getStringCellValue());
						}
						if (null != row.getCell(2)) {
							familyInformation.setRelation(row.getCell(2).getStringCellValue());
						}
						if (null != row.getCell(3)) {
							familyInformation.setEducation(row.getCell(3).getStringCellValue());
						}
						if (null != row.getCell(4)) {
							familyInformation.setWork(row.getCell(4).getStringCellValue());
						}
						if (null != row.getCell(5)) {
							if (row.getCell(5).getStringCellValue().equalsIgnoreCase("Yes")) {
								familyInformation.setMarried("Y");
							} else {
								familyInformation.setMarried("N");
							}
						}
						if (null != row.getCell(6)) {
							familyInformation.setBloodGroup(row.getCell(6).getStringCellValue());
						}
						familyInformations.add(familyInformation);
					}
					if (mainperson == 2) {
						mainperson = 1;
						family = 0;
						adminRepository.savePersonInformation(information);
						for (FamilyInformation familyInformation2 : familyInformations) {
							familyInformation2.setPersonKey(information.getId());
							adminRepository.saveFamilyInformation(familyInformation2);
						}
						familyInformations = new ArrayList<>();
						information = new PersonInformation();
						familyInformation = new FamilyInformation();
					}
				}
			}
			adminRepository.savePersonInformation(information);
			for (FamilyInformation familyInformation2 : familyInformations) {
				familyInformation2.setPersonKey(information.getId());
				adminRepository.saveFamilyInformation(familyInformation2);
			}
			workbook.close();
			file.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<PersonInformation> personInformations = adminRepository.getPersonInformation();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("personInformations", personInformations);
		modelAndView.setViewName("jsp/admin/form");

		return modelAndView;
	}

	public boolean isValidSession(HttpSession session) {
		boolean isValid = true;
		try {
			if (null != session && ("admin".equalsIgnoreCase((String) session.getAttribute("loginUserRole"))
					|| "guser".equalsIgnoreCase((String) session.getAttribute("loginUserRole")))) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@RequestMapping("/saveMarriege")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public @ResponseBody ReturnMessageDto saveMarriegeInfo(@RequestBody MarriageInfoDto mInfoDto) {
		ReturnMessageDto messageDto = new ReturnMessageDto();
		try {
			MarriageInformation marriageInformation = adminRepository
					.saveMarriageInformation(mInfoDto.getMarriageInformation());

			for (MarriedDaughter marriedDaughter : mInfoDto.getMarriedDaughter()) {
				if (null != marriedDaughter) {
					marriedDaughter.setMarriegeKey(marriageInformation.getId());
					adminRepository.saveMarriedDaughter(marriedDaughter);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageDto;
	}

	@RequestMapping("/downloadSample")
	public void downloadSample(HttpServletResponse response) throws IOException, KKDaoException {
		File file = ResourceUtils.getFile("classpath:SampleTemplate.xlsx");
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		int bytesRead;
		byte[] buf = new byte[2048];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((bytesRead = bis.read(buf)) != -1) {
			baos.write(buf, 0, bytesRead);
		}
		bis.close();
		fis.close();
		baos.flush();
		baos.close();

		response.setContentType("application/x-www-form-urlencoded");
		response.setHeader("Content-Disposition", "attachment; filename=SampleTemplate.xlsx");

		ServletOutputStream sos = response.getOutputStream();
		sos.write(baos.toByteArray());
		sos.flush();
		sos.close();
	}

	@RequestMapping("/loadMarriageList")
	public ModelAndView loadMarriagePage(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (isValidSession(session)) {
				if ("admin".equalsIgnoreCase((String) session.getAttribute("loginUserRole"))) {
					List<MarriageInformation> marriageInformation = adminRepository.getMarriageInfo();
					modelAndView.addObject("personInformations", marriageInformation);
					modelAndView.setViewName("jsp/admin/marrigeform");
				} else {
					return getApprovedList(session);
				}
			} else {
				modelAndView.setViewName("jsp/admin/login");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/viewMarriageProfile/{id}")
	public ModelAndView viewMarriageProfile(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			MarriageInformation marriageInformation = adminRepository.getMarriageInfo(id);
			List<MarriedDaughter> marriedDaughters = adminRepository.getMarriedDaughter(id);

			modelAndView.addObject("personInformations", marriageInformation);
			modelAndView.addObject("marriedDaughters", marriedDaughters);

			modelAndView.setViewName("jsp/viewmarrige");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/uploadAds")
	public ModelAndView uploadAdsPage() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<DBFile> dbFileList = adminRepository.getDBFileList();

			for (DBFile db : dbFileList) {
				String str = Base64.encodeBase64String(db.getData());
				db.setImageInStr(str);
			}

			modelAndView.addObject("dbFileList", dbFileList);
			modelAndView.setViewName("jsp/uploadAds");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addMainCategory")
	public ModelAndView addMainCategory() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("jsp/addMainCategory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/saveMainCategory")
	public ModelAndView saveMainCategory(@RequestParam("mainCategoryName") String mainCategoryName) {
		ModelAndView modelAndView = new ModelAndView();
		MainCategory mainCategory = new MainCategory();
		try {
			mainCategory.setMainCategoryName(mainCategoryName);
			adminRepository.saveMainCategory(mainCategory);
			modelAndView.setViewName("jsp/addMainCategory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addSubCategory")
	public ModelAndView addSubCategory() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			List<MainCategory> mainCategoryList = adminRepository.getMainCategoryList();
			modelAndView.addObject(mainCategoryList);
			modelAndView.setViewName("jsp/addSubCategory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/saveSubCategory")
	public ModelAndView saveSubCategory(@RequestParam("mainCategory") int mainCategoryId,
			@RequestParam("subCategoryName") String subCategoryName) {
		ModelAndView modelAndView = new ModelAndView();
		SubCategory subCategory = new SubCategory();
		try {
			subCategory.setMainCategoryId(mainCategoryId);
			subCategory.setSubCategoryName(subCategoryName);
			adminRepository.saveSubCategory(subCategory);
			List<MainCategory> mainCategoryList = adminRepository.getMainCategoryList();
			modelAndView.addObject(mainCategoryList);
			modelAndView.setViewName("jsp/addSubCategory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/uploadFile")
	@POST
	@ResponseBody
	public String uploadMultipartFile(@ModelAttribute UploadImage file) {
		try {

			MultipartFile[] mFile = file.getFiles();
			for (MultipartFile s : mFile) {
				DBFile filemode = new DBFile(s.getOriginalFilename(), s.getContentType(), s.getBytes(),
						file.getDescription());
				adminRepository.uploadFile(filemode);
			}
			return "File Uploaded Successfully";

		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}

}
