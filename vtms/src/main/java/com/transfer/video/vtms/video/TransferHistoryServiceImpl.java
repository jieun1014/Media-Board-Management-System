package com.transfer.video.vtms.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferHistoryServiceImpl implements TransferHistoryService {
	@Autowired
	TransferHistoryMapper transferHistoryMapper;
	
	@Override//전송 이력 조회
	public List<TransferHistory> getTransferHistories(TransferHistory transferHistory) {
		return this.transferHistoryMapper.selectAll(transferHistory);
	}

	@Override//전송 이력 상세 조회
	public TransferHistory getTransferHistory(TransferHistory transferHistory) {
		return this.transferHistoryMapper.select(transferHistory);
	}

	@Override//영상 파일 전송 장소 조회
	public List<String> getTransferPlaces() {
		return transferHistoryMapper.selectAllPlace();
	}
}
