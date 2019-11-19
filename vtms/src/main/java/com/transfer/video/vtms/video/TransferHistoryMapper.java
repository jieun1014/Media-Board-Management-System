package com.transfer.video.vtms.video;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransferHistoryMapper {
	public List<TransferHistory> selectAll(TransferHistory transferHistory);
	public TransferHistory select(TransferHistory transferHistory);
	public void insert(TransferHistory transferHistory);
	public List<String> selectAllPlace();
}
