<jsp:include page="templates/member/header.jsp"></jsp:include>
    <script>
        System.import('resources/js/home-template.js').catch(function (err) {
            console.error(err);
        });
    </script>
    <style type="text/css">
        .vertical-center {
            min-height: 100%; 
            min-height: 100vh;
            display: flex;
            align-items: center;
        }
    </style>
    <data-content>
        <div class="vertical-center">
            <div class="sk-wave">
                <div class="sk-rect sk-rect1"></div>
                <div class="sk-rect sk-rect2"></div>
                <div class="sk-rect sk-rect3"></div>
                <div class="sk-rect sk-rect4"></div>
                <div class="sk-rect sk-rect5"></div>
            </div>
        </div>
    </data-content>


<jsp:include page="templates/member/footer.jsp"></jsp:include>