
//script for validating form fields

let reportSubmitBtn = $("#reportSubmit");
let isValid = true;

var checkReportNumber = () => {
    let reportNumber = $("#reportNumber");
    reportNumber.blur(() => {
        if(reportNumber.val() === "" || reportNumber.val() === undefined) {
            reportNumber.addClass("is-invalid");
            isValid = false;
            setBtn();
        }
        else {
            if(reportNumber.hasClass("is-invalid")) {
                reportNumber.removeClass("is-invalid");
            }
            isValid = true;
            setBtn();
        }
    })
};

var checkReportNote = () => {
    let reportNote = $("#reportNote");
    reportNote.blur(() => {
        if(reportNote.val() === "" || reportNote.val() === undefined) {
            reportNote.addClass("is-invalid");
            isValid = false;
            setBtn();
        }
        else {
            if(reportNote.hasClass("is-invalid")) {
                reportNote.removeClass("is-invalid");
            }
            isValid = true;
            setBtn();
        }
    })
};

let setBtn = () => {
    if(isValid === true) {
        reportSubmitBtn.attr('disabled', false);
    }
    else {
        reportSubmitBtn.attr('disabled', true);
    }
};

checkReportNumber();
checkReportNote();