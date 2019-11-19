package com.transfer.video.vtms.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TransferHistoryController {
	@Autowired
	TransferHistoryService transferHistoryService;
	
	@GetMapping("/transfer/history")
	public ModelAndView getTransferHistories() {//전송 이력 화면 출력
		List<String> transferPlaces = transferHistoryService.getTransferPlaces();
		
		ModelAndView mav = new ModelAndView("/video/list");
		mav.addObject("transferPlaces", transferPlaces);
		
		return mav;
	}
	
	@GetMapping(value = "/transfer/history", consumes = "application/json")
	public List<TransferHistory> getTransferHistories(String place, String deviceIp) {//전송 이력 조회
		TransferHistory transferHistory = new TransferHistory();
		transferHistory.setPlace(place);
		transferHistory.setDeviceIp(deviceIp);
		
		return this.transferHistoryService.getTransferHistories(transferHistory);
	}
	
	@GetMapping("/transfer/history/{no}")
	public ModelAndView getTransferHistory(@PathVariable("no") int no) {//전송 이력 상세 조회
		TransferHistory transferHistory = new TransferHistory();
		transferHistory.setNo(no);
		
		transferHistory = this.transferHistoryService.getTransferHistory(transferHistory);
		
		ModelAndView mav = new ModelAndView("/video/detail");
		mav.addObject("transferHistory", transferHistory);
		
		return mav;
	}
}
