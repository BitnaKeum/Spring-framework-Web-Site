package com.kwce.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kwce.domain.BoardVO;
import com.kwce.paging.*;
import com.kwce.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list page get...");
		model.addAttribute("list",service.listAll());
		return "board/list";
	}
	
	@RequestMapping(value="/list_SEOUL",method=RequestMethod.GET)
	public String list_SEOUL(Model model) throws Exception{
		logger.info("list_SEOUL page get...");
		model.addAttribute("list",service.list_SEOUL());
		return "board/list_SEOUL";
	}
	
	@RequestMapping(value="/list_GYEONGGI",method=RequestMethod.GET)
	public String list_GYEONGGI(Model model) throws Exception{
		logger.info("list_GYEONGGI page get...");
		model.addAttribute("list",service.list_GYEONGGI());
		return "board/list_GYEONGGI";
	}
	
	@RequestMapping(value="/list_INCHEON",method=RequestMethod.GET)
	public String list_INCHEON(Model model) throws Exception{
		logger.info("list_INCHEON page get...");
		model.addAttribute("list",service.list_INCHEON());
		return "board/list_INCHEON";
	}
	
	@RequestMapping(value="/list_DAEJEON",method=RequestMethod.GET)
	public String list_DAEJEON(Model model) throws Exception{
		logger.info("list_DAEJEON page get...");
		model.addAttribute("list",service.list_DAEJEON());
		return "board/list_DAEJEON";
	}
	
	@RequestMapping(value="/list_CHUNGCHEONG",method=RequestMethod.GET)
	public String list_CHUNGCHEONG(Model model) throws Exception{
		logger.info("list_CHUNGCHEONG page get...");
		model.addAttribute("list",service.list_CHUNGCHEONG());
		return "board/list_CHUNGCHEONG";
	}
	
	@RequestMapping(value="/list_KANGWON",method=RequestMethod.GET)
	public String list_KANGWON(Model model) throws Exception{
		logger.info("list_KANGWON page get...");
		model.addAttribute("list",service.list_KANGWON());
		return "board/list_KANGWON";
	}
	
	@RequestMapping(value="/list_DAEGU",method=RequestMethod.GET)
	public String list_DAEGU(Model model) throws Exception{
		logger.info("list_DAEGU page get...");
		model.addAttribute("list",service.list_DAEGU());
		return "board/list_DAEGU";
	}
	
	@RequestMapping(value="/list_JEOLLA",method=RequestMethod.GET)
	public String list_JEOLLA(Model model) throws Exception{
		logger.info("list_JEOLLA page get...");
		model.addAttribute("list",service.list_JEOLLA());
		return "board/list_JEOLLA";
	}
	
	@RequestMapping(value="/list_BUSAN",method=RequestMethod.GET)
	public String list_BUSAN(Model model) throws Exception{
		logger.info("list_BUSAN page get...");
		model.addAttribute("list",service.list_BUSAN());
		return "board/list_BUSAN";
	}
	
	@RequestMapping(value="/list_GYEONGSANG",method=RequestMethod.GET)
	public String list_GYEONGSANG(Model model) throws Exception{
		logger.info("list_GYEONGSANG page get...");
		model.addAttribute("list",service.list_GYEONGSANG());
		return "board/list_GYEONGSANG";
	}
	
	@RequestMapping(value="/list_JEJU",method=RequestMethod.GET)
	public String list_JEJU(Model model) throws Exception{
		logger.info("list_JEJU page get...");
		model.addAttribute("list",service.list_JEJU());
		return "board/list_JEJU";
	}
	
	@RequestMapping(value="/listCriteria",method=RequestMethod.GET)
	public String listCriteria(Model model, Criteria criteria) throws Exception{
		logger.info("listCriteria...");
		model.addAttribute("list", service.listCriteria(criteria));
		return "board/list_criteria";
	}
 
	@RequestMapping(value="/listPaging", method=RequestMethod.GET)
	public String listPaging(Model model, Criteria criteria) throws Exception{
		logger.info("listPaging...");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(service.countBoard(criteria));
		
		model.addAttribute("list", service.listCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);
		return "/board/list_paging";
		
	}
	
	@RequestMapping(value="/domain",method=RequestMethod.GET)
	public String domain(Model model) throws Exception{
		logger.info("domain page get...");
		model.addAttribute("list",service.listAll());
		return "board/domain";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String RegisterGET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register page get...");
		return "board/register";
	}

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String RegisterPOST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value="/register_SEOUL",method=RequestMethod.GET)
	public String Register_SEOUL_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_SEOUL page get...");
		return "board/register_SEOUL";
	}

	@RequestMapping(value="/register_SEOUL",method=RequestMethod.POST)
	public String Register_SEOUL_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_SEOUL page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		return "redirect:/board/list_SEOUL";
	}
	
	@RequestMapping(value="/register_GYEONGGI",method=RequestMethod.GET)
	public String Register_GYEONGGI_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_GYEONGGI page get...");
		return "board/register_GYEONGGI";
	}

	@RequestMapping(value="/register_GYEONGGI",method=RequestMethod.POST)
	public String Register_GYEONGGI_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_GYEONGGI page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		return "redirect:/board/list_GYEONGGI";
	}
	
	@RequestMapping(value="/register_INCHEON",method=RequestMethod.GET)
	public String Register_INCHEON_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_INCHEON page get...");
		return "board/register_INCHEON";
	}

	@RequestMapping(value="/register_INCHEON",method=RequestMethod.POST)
	public String Register_INCHEON_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_INCHEON page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_INCHEON";
	}
	
	@RequestMapping(value="/register_DAEJEON",method=RequestMethod.GET)
	public String Register_DAEJEON_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_DAEJEON page get...");
		return "board/register_DAEJEON";
	}

	@RequestMapping(value="/register_DAEJEON",method=RequestMethod.POST)
	public String Register_DAEJEON_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_DAEJEON page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_DAEJEON";
	}
	
	@RequestMapping(value="/register_CHUNGCHEONG",method=RequestMethod.GET)
	public String Register_CHUNGCHEONG_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_CHUNGCHEONG page get...");
		return "board/register_CHUNGCHEONG";
	}

	@RequestMapping(value="/register_CHUNGCHEONG",method=RequestMethod.POST)
	public String Register_CHUNGCHEONG_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_CHUNGCHEONG page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_CHUNGCHEONG";
	}
	
	@RequestMapping(value="/register_KANGWON",method=RequestMethod.GET)
	public String Register_KANGWON_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_KANGWON page get...");
		return "board/register_KANGWON";
	}

	@RequestMapping(value="/register_KANGWON",method=RequestMethod.POST)
	public String Register_KANGWON_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_KANGWON page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_KANGWON";
	}
	
	@RequestMapping(value="/register_DAEGU",method=RequestMethod.GET)
	public String Register_DAEGU_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_DAEGU page get...");
		return "board/register_DAEGU";
	}

	@RequestMapping(value="/register_DAEGU",method=RequestMethod.POST)
	public String Register_DAEGU_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_DAEGU page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_DAEGU";
	}
	
	@RequestMapping(value="/register_JEOLLA",method=RequestMethod.GET)
	public String Register_JEOLLA_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_JEOLLA page get...");
		return "board/register_JEOLLA";
	}

	@RequestMapping(value="/register_JEOLLA",method=RequestMethod.POST)
	public String Register_JEOLLA_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_JEOLLA page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_JEOLLA";
	}
	
	@RequestMapping(value="/register_BUSAN",method=RequestMethod.GET)
	public String Register_BUSAN_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_BUSAN page get...");
		return "board/register_BUSAN";
	}

	@RequestMapping(value="/register_BUSAN",method=RequestMethod.POST)
	public String Register_BUSAN_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_BUSAN page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
	
		return "redirect:/board/list_BUSAN";
	}
	
	@RequestMapping(value="/register_GYEONGSANG",method=RequestMethod.GET)
	public String Register_GYEONGSANG_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_GYEONGSANG page get...");
		return "board/register_GYEONGSANG";
	}

	@RequestMapping(value="/register_GYEONGSANG",method=RequestMethod.POST)
	public String Register_GYEONGSANG_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_GYEONGSANG page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
		
		return "redirect:/board/list_GYEONGSANG";
	}
	
	@RequestMapping(value="/register_JEJU",method=RequestMethod.GET)
	public String Register_JEJU_GET(MultipartFile uploadfile,BoardVO board,Model model) throws Exception{
		logger.info("register_JEJU page get...");
		return "board/register_JEJU";
	}

	@RequestMapping(value="/register_JEJU",method=RequestMethod.POST)
	public String Register_JEJU_POST(MultipartFile uploadfile,BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("register_JEJU page post...");
		logger.info(board.toString());
		logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
	    logger.info("���� ũ��: {}", uploadfile.getSize());
		service.regist(board);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		final String UPLOAD_PATH = "C:/Users/CEO/Documents/workspace-sts-3.9.6.RELEASE/web_tutorial/src/main/webapp/WEB-INF/views/board/";
	       String saveName = board.getTitle()+".PNG";

	       logger.info("saveName: {}",saveName);

	       // ������ File ��ü�� ����(������ ����)��
	       File saveFile = new File(UPLOAD_PATH,saveName); // ������ ���� �̸�, ������ ���� �̸�

	       try {
	    	   FileCopyUtils.copy(uploadfile.getBytes(),saveFile); // ���ε� ���Ͽ� saveFile�̶�� ������ ����
	       } catch (IOException e) {
	           e.printStackTrace();
	           return null;
	       }
	       
	
		return "redirect:/board/list_JEJU";
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String read(@RequestParam("bno") int bno,Model model) throws Exception{
		logger.info("read page get....");
		model.addAttribute(service.read(bno));
		return "board/read";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(@RequestParam("bno") int bno,Model model) throws Exception{
		logger.info("modify page get....");
		model.addAttribute(service.read(bno));
		return "board/modify";
	}

	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO board,RedirectAttributes rttr) throws Exception{
		logger.info("modify page post....");
		logger.info(board.toString());
		service.modify(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}	
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		logger.info("remove page post......");
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/remove_SEOUL", method=RequestMethod.POST)
	public String remove_SEOUL(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		service.remove(bno);
		logger.info("remove page post......");
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list_SEOUL";
	}
	
	@RequestMapping(value="/clear", method=RequestMethod.POST)
	public String clear(BoardVO board, RedirectAttributes rttr) throws Exception{
		service.removeall(board);
		logger.info("clear page post......");
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	
	   @RequestMapping(value="/read", method = RequestMethod.POST)
	   public String like(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
	      service.like(bno);
	      logger.info("like page post....");
	      rttr.addFlashAttribute("msg", "SUCCESS");
	      return "redirect:/board/list";
	   }
	   
	   @RequestMapping(value="/read/hate", method = RequestMethod.POST)
	   public String hate(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
	      service.hate(bno);
	      logger.info("hate page post....");
	      rttr.addFlashAttribute("msg", "SUCCESS");
	      return "redirect:/board/list";
	   }
	   

}
	

