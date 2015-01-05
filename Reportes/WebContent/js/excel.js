
$(document).ready(function () {
   
        $("#btnExport").click(function(e) {

        	var table = document.getElementById("tbl_eventos");
        	var tbl = tableToJson(table);
        	var jsonp = JSON.stringify(tbl);
        		window.open('excel.jsp?id='+jsonp);
        		e.preventDefault();
	});
        
        
        
        
        
      function tableToJson(table) {
            var data = [];

            // first row needs to be headers
            var headers = [];
            for (var i=0; i<table.rows[0].cells.length; i++) {
                headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi,'');
            }

            // go through cells
            for (var i=1; i<table.rows.length; i++) {

                var tableRow = table.rows[i];
                var rowData = {};

                for (var j=0; j<tableRow.cells.length; j++) {

                    rowData[ headers[j] ] = tableRow.cells[j].innerHTML;

                }

                data.push(rowData);
            }       

            return data;
        }
        
        
        
        
        
        
        
        
        
});