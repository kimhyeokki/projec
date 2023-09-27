package com.khk11.service;
import java.sql.ResultSet;

import com.khk11.dto.Member;

public interface MemberService {
	int insertMember(Member member);
	int deleteMember(String userID, String userPW);
	int deleteMember(Member member);
	Member loginMember(String userID, String userPW);
	int updateMember(Member member);
	Member infoMember(String userID);
}
