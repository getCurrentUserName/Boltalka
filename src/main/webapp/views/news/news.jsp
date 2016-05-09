<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${newsList}" var="newsId">
    <div class="col-md-12" style="background-color: #fafafa">
        <div class="card" style="padding: 1px 10px;">
            <h3>${newsId.title}</h3>
            <hr width="100%" />
            <h4>${newsId.text}</h4>
            <hr width="100%" />
            <h5 class="right" align="right">Добавил: ${newsId.userId.nickname} в ${newsId.date}</h5>
        </div>
    </div>
    <div>
        <br>&nbsp;
    </div>
</c:forEach>
<div class="card" align="right" style="padding: 20px"><h4>
    <c:forEach begin="0" end="${pages}" var="page">
        <a href="/news/${page + 1}">${page + 1}</a>
    </c:forEach></h4>
</div>