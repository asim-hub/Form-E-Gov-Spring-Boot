<script>
    function addressFunction() {
        var element1 = document.getElementById("moneda");
        var element2 = document.getElementById("tipCred");
        var element3 = document.getElementById("tipDob");
        if (element1.value == "EUR" && element2.value == "CREDIT_NEVOI_PERSONALE" && element3.value == "FIX") {
            document.getElementById("credit_interest").value = 13;
                } else {
                    document.getElementById("credit_interest").value = 17;
                }
            }
</script>