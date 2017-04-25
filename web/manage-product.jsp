<jsp:include page="templates/member/header.jsp"></jsp:include>
    <script>
        System.import('resources/js/manage-product-template.js').catch(function (err) {
            console.error(err);
        });
    </script>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
            <jsp:include page="templates/member/manage-product-left-sidebar.jsp"></jsp:include>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
                <data-content>     
                    Loading...
                </data-content>
            </div>
        </div>
    </div>
<jsp:include page="templates/member/footer.jsp"></jsp:include>
