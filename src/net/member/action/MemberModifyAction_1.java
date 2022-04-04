package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberModifyAction_1 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		HttpSession session=request.getSession(true);
		String id=(String)session.getAttribute("id");
		
		if(id==null) {
			forward.setRedirect(true);
			forward.setPath("./MemberLogin.me");
			return forward;
		}
		
		MemberDAO memberdao=new MemberDAO();
		MemberBean dto= memberdao.getMember(id);
		
		request.setAttribute("member", dto); //dto로 가져온 회원 정보를 request에 저장한다.
		
		forward.setRedirect(false);
		forward.setPath("./member/member_info.jsp"); //회원정보보기 페이지로 포워딩
		return forward;
	}

}
