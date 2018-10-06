
//script for validating form fields

let reportSubmitBtn = $("#reportSubmit");
let reportNumber = $("#reportNumber");
let reportNote = $("#reportNote");
let clientPib = $("#clientPib");


let checkReportNumber = () => {
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

let checkReportNote = () => {
    reportNote.on('blur', () => {
        if(reportNote.val() === ""){
            reportNote.addClass('is-invalid')
        }
        else {
            reportNote.removeClass('is-invalid')
        }
    });
};

let checkClientPib = () => {
    clientPib.on('blur', () => {
        if(clientPib.val() !== "") {
            if(isNaN(clientPib)) {
                clientPib.addClass('is-invalid');
            }
            else {
                clientPib.removeClass('is-invalid');
            }
        }
    });
};

checkReportNumber();
checkReportNote();
checkClientPib();