
//script for validating form fields

let reportSubmitBtn = $("#reportSubmit");
let reportNumber = $("#reportNumber");
let reportNote = $("#reportNote");


var checkReportNumber = () => {
   reportNumber.on('blur', () => {
       if(reportNumber.val() !== undefined && reportNumber.val() !== "") {
           if(isNaN(reportNumber.val())) {
               reportNumber.addClass('is-invalid');
           }
           else {
               reportNumber.removeClass('is-invalid');
           }
       }
   });
};
checkReportNumber();