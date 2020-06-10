
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<div class="container text-center" >
    <nav aria-label="..." >
        <ul class="pagination">

            <li class="page-item ${pageCategory.hasPrev ? '':'disabled'}">
                <a class="page-link" href="?pageCategory.pageNumber=1${url}" tabindex="-1">«</a>
            </li>
            <li class="page-item ${pageCategory.hasPrev ? '':'disabled'}">
                <a class="page-link" href="?pageCategory.pageNumber=${pageCategory.pageNumber-1}${url}" tabindex="-1">‹</a>
            </li>

            <c:forEach begin="${pageCategory.start}" end="${pageCategory.end}" varStatus="vs">
            <li class="page-item ${vs.index  == pageCategory.pageNumber ? 'active':''}">
                <a class="page-link" href="?pageCategory.pageNumber=${vs.index}${url}">
                        ${vs.index}
                </a>
            </li>

            </c:forEach>

            <li class="page-item  ${pageCategory.hasNext ? '':'disabled'}">
    <a class="page-link" href="?pageCategory.pageNumber=${pageCategory.pageNumber+1}${url}">›</a>
</li>
            <li class="page-item  ${pageCategory.hasNext ? '':'disabled'}">
                <a class="page-link" href="?pageCategory.pageNumber=${pageCategory.totalPage}${url}">»</a>
            </li>
        </ul>
    </nav>
</div>
