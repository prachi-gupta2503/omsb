
<%@ include file="init.jsp"%>

<!-- Modal -->
<div class="modal fade omsb-modal" id="assignmentdetails" tabindex="-1" role="dialog" aria-labelledby="assignmentdetailsTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">
          <liferay-ui:message key="trainee-assignment-details" />
        </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="blockdetail_table">
          <table class="table">
            <thead>
              <tr>
                <th scope="col"><liferay-ui:message key="rotation-training-site" /></th>
                <th scope="col"><liferay-ui:message key="training-site" /></th>
                <th scope="col"><liferay-ui:message key="total-no-of-blocks" /></th>
              </tr>
            </thead>
            <tbody id="traineeRotationModalBody">
              
            </tbody>
          </table>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal">
          cancel
        </button>
      </div>
    </div>
  </div>
</div>