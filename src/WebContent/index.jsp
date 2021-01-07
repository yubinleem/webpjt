<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>

    <title>게시판 목록</title>

    <!-- CSS 영역 -->

    <style type="text/css">

        * {font-size: 9pt;}

        p {width: 600px; text-align: right;}

        table thead tr th {background-color: gray;}

    </style>

    <!-- //CSS 영역 -->

    <!-- 자바스크립트 영역 -->
	
    <script type="text/javascript">

        function goUrl(url) {

           location.href=url;

        }

    </script>

    <!-- //자바스크립트 영역 -->

    </head>

    <body>
	
       <!-- 검색 폼 영역 -->

       <form name="searchForm" action="" method="get">

       <p>

           <select name="searchType">

               <option value="ALL">전체검색</option>

               <option value="SUBJECT">제목</option>

               <option value="WRITER">작성자</option>

               <option value="CONTENTS">내용</option>

           </select>

           <input type="text" name="searchText" value="" />

           <input type="submit" value="검색" />

       </p>

       </form>

       <!-- //검색 폼 영역 -->

       <!-- 게시판 목록 영역 -->

       <table border="1" summary="게시판 목록">

           <caption>게시판 목록</caption>

           <colgroup>

               <col width="50" />

               <col width="300" />

               <col width="80" />

               <col width="100" />

               <col width="70" />

           </colgroup>  

           <thead>

               <tr>

                    <th>번호</th>

                    <th>제목</th>

                    <th>작성자</th>

                    <th>등록 일시</th>

                    <th>조회수</th>

               </tr>

           </thead>

           <tbody>

               <tr>

                    <td align="center" colspan="5">등록된 게시물이 없습니다.</td>

               </tr>

               <tr>

                    <td align="center">1</td>

                    <td><a href="boardView.jsp">동해물과 백두산이 마르고 닳도록 하...</a></td>

                    <td align="center">김연석</td>

                    <td align="center">2013.06.24</td>

                    <td align="center">10</td>

               </tr>

           </tbody>

           <tfoot>

               <tr>

                    <td align="center" colspan="5">1</td>

               </tr>

           </tfoot>

       </table>

       <!-- //게시판 목록 영역 -->

       <!-- 버튼 영역 -->

       <p>

           <input type="button" value="목록" onclick="goUrl('boardList.jsp');" />

           <input type="button" value="글쓰기" onclick="goUrl('boardWriteForm.jsp');" />

       </p>

       <!-- //버튼 영역 -->

    </body>

    </html>