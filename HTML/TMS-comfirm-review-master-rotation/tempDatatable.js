    const configureProceduresData = [
        {
            "program" : "Adult Cardiology",
            "block" : "Block-1",
            "Level" : "R1",
            "Receiver" : "Shareef Khilafi",
            "Role" : "Trainee",
            "Rotation" : "Rotation",
            "Status" : "Confirmed",
            "Confirmed on" : "19-08-2023",
            "days" : "1"
        },
        {
            "program" : "Diabetes",
            "block" : "Block-1",
            "Level" : "R2",
            "Receiver" : "Imran",
            "Role" : "Trainee",
            "Rotation" : "Rotation",
            "Status" : "NotConfirmed",
            "Confirmed on" : "19-08-2023",
            "days" : "2"
        },
        {
            "program" : "Adult Cardiology",
            "block" : "Block-3",
            "Level" : "R3",
            "Receiver" : "Abbas",
            "Role" : "Trainee",
            "Rotation" : "Rotation",
            "Status" : "Confirmed",
            "Confirmed on" : "19-08-2023",
            "days" : "13"
        },
        {
            "program" : "Diabetes",
            "block" : "Block-2",
            "Level" : "R4",
            "Receiver" : "Ayaan",
            "Role" : "Trainee",
            "Rotation" : "Rotation",
            "Status" : "Confirmed",
            "Confirmed on" : "19-08-2023",
            "days" : "9"
        },
        {
            "program" : "Diabetes",
            "block" : "Block-3",
            "Level" : "R5",
            "Receiver" : "Abbas",
            "Role" : "Trainee",
            "Rotation" : "Rotation",
            "Status" : "NotConfirmed",
            "Confirmed on" : "19-08-2023",
            "days" : "4"
        }
    ];

    $(document).ready(function(){
        configureProceduresDatatable(configureProceduresData);
    })

    function configureProceduresDatatable(configureProceduresData){
        let configureProceduresHTML = "";
        $("#configureProcedures tbody").html("");
        $('#configureProcedures').DataTable().destroy();
        configureProceduresData.forEach(function(item, index){
            configureProceduresHTML += `<tr>
            <td>${item.program}</td>
            <td>${item.block}</td>
            <td>${item.Level}</td>
            <td>${item.Receiver}</td>
            <td>${item.Role}</td>
            <td>${item.Rotation}</td>
            ${
                (() => {
                    if(item.Status == "Confirmed") {
                        return `<td><span class="omsb-complete-bg">Confirmed</span></td>`;
                    }
                    if(item.Status == "NotConfirmed") {
                        return `<td><span class="omsb-stop-bg">Not Confirmed</span></td>`;
                    }
                })()
            }
            <td>19-08-2023</td>
            <td>${item.days}</td>
        </tr>`
        });

       $("#configureProcedures tbody").html(configureProceduresHTML);
       $('#configureProcedures').DataTable({
        "bLengthChange": false,
        "bFilter": false,
       });
       $("[data-bs-toggle='dropdown']").click(function () {
        $(this).siblings("ul.dropdown-menu").toggleClass("show");
    })
    }

    function filterData(){
        debugger;   
        const filterData = {
            "programValue" : $("#programcode").val(),
            "Blockcode" : $("#Block-code").val(),
            "statuscode" : $("#status-code").val()
        }
        
        const FileredData = configureProceduresData.filter((item, index) => {
            if(filterData.programValue && filterData.Blockcode && filterData.statuscode){
               return (item.program == filterData.programValue && item.block == filterData.Blockcode && item.Status == filterData.statuscode);
            }else if(filterData.programValue && filterData.Blockcode && filterData.statuscode == ""){
                return (item.program == filterData.programValue && item.block == filterData.Blockcode);            }
            else if(filterData.programValue && filterData.Blockcode == "" && filterData.statuscode ){
                return (item.program == filterData.programValue && item.Status == filterData.statuscode);
            }else if(filterData.programValue == "" && filterData.Blockcode && filterData.statuscode){
                return (item.block == filterData.Blockcode && item.Status == filterData.statuscode);
             }
            else if(filterData.programValue && filterData.Blockcode == "" && filterData.statuscode == ""){
                return item.program == filterData.programValue;
            }else if(filterData.programValue == "" && filterData.Blockcode && filterData.statuscode == ""){
                return item.block == filterData.Blockcode;
            }else if(filterData.programValue == "" && filterData.Blockcode == "" && filterData.statuscode){
                return item.Status == filterData.statuscode;
            }else if(filterData.statuscode == "" && filterData.Blockcode == "" && filterData.statuscode == ""){
                return item;
            }
        });
        configureProceduresDatatable(FileredData);
    }


    /*==================== Configure Notification Threshold =======================*/

    let configureProceduresThresholdData = [
        {
            "id" : "1",
            "program" : "Adult Cardiology",
            "notificationDays" : "27",
        },
        {
            "id" : "2",
            "program" : "MedicalGenetics",
            "notificationDays" : "27",
        },
        {
            "id" : "3",
            "program" : "Diabetes",
            "notificationDays" : "27",
        },
        {
            "id" : "4",
            "program" : "Otology",
            "notificationDays" : "27",
        },
        {
            "id" : "5",
            "program" : "Pediatrics-Hematology",
            "notificationDays" : "27",
        },
        {
            "id" : "6",
            "program" : "Emergency Medicine",
            "notificationDays" : "27",
        }
       

    ];

    $(document).ready(function(){
        ConfigureNotificationThresholdDatatable(configureProceduresThresholdData);  
    })


    function ConfigureNotificationThresholdDatatable(configureProceduresThresholdData){
        let ConfigureNotificationHTML = "";
        $("#Tablethreshold tbody").html("");
        $('#Tablethreshold').DataTable().destroy();
        configureProceduresThresholdData.forEach(function(item, index){
            ConfigureNotificationHTML += `<tr>
            <td>${item.program}</td>
            <td>${item.notificationDays}</td>
            <td>
                <div class="dropdown dropup">
                    <button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class=""></i>
                    </button>
                    <ul class="dropdown-menu" style="">
                        <li><a href="javascript:void(0)" onClick='editRow(${JSON.stringify(item)})' class="dropdown-item" ><img src="../images/svg/fi-rr-edit.svg"> Edit</a></li>
                        <li><a href="javascript:void(0)" onClick="deleteRow(${item.id})" class="dropdown-item"><img src="../images/svg/fi-rr-delete.svg"> Delete</a></li>
                    </ul>    
                </div>
            </td>
        </tr>`
        });

       $("#Tablethreshold tbody").html(ConfigureNotificationHTML);
        $('#Tablethreshold').DataTable({
            "bLengthChange": false,
            "bFilter": false,
            dom: 'Bfrtip',
            buttons: [
                {
                    extend: 'collection',
                    text: 'Export As',
                    buttons: ['copy', 'excel', 'csv', 'pdf', 'print']
                },
                {
                    extend: 'colvis',
                    hide: [1]
                }

                
            ]
            
        });
       $("[data-bs-toggle='dropdown']").click(function () {
        $(this).siblings("ul.dropdown-menu").toggleClass("show");
       })
    }  

    function filterthresholdData(){
        debugger;
        const filterData = $("#programtheshold").val();
        const FileredData = configureProceduresThresholdData.filter((item, index) => {
            if(filterData){
                return item.program == filterData
            }else{
                return item     
            }
        });
        ConfigureNotificationThresholdDatatable(FileredData);
    }

    

    var deleteRowID = "";
    function deleteRow(id){
        debugger;
        deleteRowID = id;
        $("#deleteConfirmation").click();
    }

    function confirmDelete(){
        debugger;
        const deletedData = configureProceduresThresholdData.filter((item, index) => item.id != deleteRowID);
        configureProceduresThresholdData = deletedData
        ConfigureNotificationThresholdDatatable(deletedData);
        $("#cancelConfirmDelete").click();
        deleteRowID = "";
    }

    function editRow(rowDtls){
        debugger;
        $("#ProgramNameVal").text(rowDtls.program);
        $("#notificationDayVal").val(rowDtls.notificationDays);
        $("#dtlsID").val(rowDtls.id);
        $("#editBtn").click();
    }

    
    
    function updatedDtls(){
        debugger;
        const notificationValue = $("#notificationDayVal").val();
        const rowId = $("#dtlsID").val();

        const UpdatedData =  configureProceduresThresholdData.map((item, index) => {
            if(item.id == rowId){
                return {...item, notificationDays : notificationValue}
            }else{
                return item
            }
        });

        ConfigureNotificationThresholdDatatable(UpdatedData);
        $("#cancelPopup").click();

    }

  
    function saveData(){
        debugger;
        $(".programCodeAlert").hide();
        const programCode = $("#addprogramcode").val();
        const addNotificationDays = $("#addnotificationDayVal").val();
        let programCodeValidation = true;
        configureProceduresThresholdData.forEach(function(item, index){
           if(item.program == programCode){
                programCodeValidation = false;
           }
        });

        if(programCodeValidation){
            const obj =  { "id" : "101", "program" : programCode, "notificationDays" : addNotificationDays}
            configureProceduresThresholdData.push(obj);
            ConfigureNotificationThresholdDatatable(configureProceduresThresholdData);
            $("#addprogramcode").val("");
            $("#addnotificationDayVal").val("");
            $('.js-basic-single').select2();
            $("#cancelPopupSave").click();
        }else{
            $(".programCodeAlert").show();
            return false;
        }


    }


    