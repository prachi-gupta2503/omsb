<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<liferay-theme:defineObjects />
<tr id="row-${index}">
	<td>${fileName}</td>
	<td>
		<button class="btn delete_btn${index}" data-table-id="${tableId}" value="delete" type="button" data-toggle="modal" 
		 data-target="#delete-confirm" data-rowcount="${index}" data-final-file-id=${finalFileId }>
	 		 <img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" alt=""> 
	 	</button>
	 </td>
</tr>


<script>
$('.delete_btn'+${index}).on('click', function(){
	var row = $(this).attr('data-rowcount');
	var tableId = $(this).attr('data-table-id');
	var finalFileId = $(this).attr('data-final-file-id');
	console.log('row is while click on delete_btn ?', row);
	$(".delete-final").attr("row-data", row);
	$(".delete-final").attr("row-table-id", tableId);
	$(".delete-final").attr("row-final-file-id", finalFileId);
});


</script>

