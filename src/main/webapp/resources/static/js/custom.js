
//function to add reportContent fields
let count= 0;
let report = {
          reportNumber: 0,
          reportNote: "",
          client: {
              name: "",
              street: "",
              pib: 0
          },
          reportContent: [
              {
                  serialNumber: 0,
                  content: "",
                  qty: 0,
                  unitMeasure: "",
                  pricePerMeasure: 0.0
              }
          ]
      };


let addReportContentFields = () => {
   let area = $(".reportArea");
   for(let i=count; i === report.reportContent.length - 1; i++) {
       let field = $("#reportFields").clone();
       field.find('input').each(function () {
           this.name = this.name.replace('[0]', '['+ i +']');
           this.id = this.id.replace('0', i.toString());
       });
       field.find('textarea').each(function () {
           this.name = this.name.replace('[0]', '['+ i +']');
           this.id = this.id.replace('0', i.toString());
       });

       area.append(field);
   }
};

let addField = () => {
   let reportField = {
       serialNumber: 0,
       content: "",
       qty: 0,
       unitMeasure: "",
       pricePerMeasure: 0.0
   };

   report.reportContent.push(reportField);
   count++;
   addReportContentFields();

};

let saveReport = () => {

    let url = "http://localhost:8080/report/create";

    report.reportNumber = $('#reportNumber').val();
    report.reportNote = $('#reportNote').val();
    report.client.name = $('#clientName').val();
    report.client.street = $('#clientStreet').val();
    report.client.pib = $('#clientPib').val();
    for(let i = 0; i < report.reportContent.length; i++) {
        report.reportContent[i].serialNumber = $('#serialNumber' + i).val();
        report.reportContent[i].content= $('#content' + i).val();
        report.reportContent[i].qty= $('#qty' + i).val();
        report.reportContent[i].unitMeasure= $('#unitMeasure' + i).val();
        report.reportContent[i].pricePerMeasure= $('#pricePerMeasure' + i).val();
    }

    postData(url, report);
};

let postData = (url, data) => {
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: url,
        type: 'POST',
        dataType: "json",
        data: JSON.stringify(data),
        success: (response) => {
            console.log(response);
            document.getElementById("reportForm").reset();
            $("#pdfUrl").attr('href', 'http://localhost:8080/report/pdf/' + response.id);
            $("#exampleModal").modal();
        },
        error: (error) => {
            console.log(error);
        }
    })
};