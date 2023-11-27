create table bank_details (
	uuid_ VARCHAR(75) null,
	bank_details_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	ec_member_request_id LONG,
	bank_name STRING null,
	account_number STRING null,
	bank_branch STRING null
);

create table block_week_metadata_details_rel (
	uuid_ VARCHAR(75) null,
	block_week_metadata_details_rel_id LONG not null primary key,
	blocks_metadata_details_rel_id LONG,
	week_no VARCHAR(75) null,
	week_start_date DATE null,
	week_end_date DATE null,
	group_id LONG,
	company_id LONG,
	created_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table blocks_metadata_details_rel (
	uuid_ VARCHAR(75) null,
	blocks_metadata_details_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	progduration_tl_blocks_lt_id LONG,
	block_no VARCHAR(75) null,
	block_start_date DATE null,
	block_end_date DATE null
);

create table competencies_master (
	uuid_ VARCHAR(75) null,
	competencies_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	competency_name STRING null
);

create table cpt_code_master (
	uuid_ VARCHAR(75) null,
	cpt_code_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	cpt_code_name STRING null
);

create table duty_assignment_master (
	uuid_ VARCHAR(75) null,
	duty_assignment_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	duty_type_id LONG,
	assignment VARCHAR(75) null,
	status VARCHAR(75) null,
	color_code VARCHAR(75) null
);

create table duty_log (
	uuid_ VARCHAR(75) null,
	duty_log_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	trainee_id LONG,
	program_duty_assignment_id LONG,
	blocks_metadata_details_rel_id LONG,
	residency_level_id LONG,
	multi_days BOOLEAN,
	start_date DATE null,
	end_date DATE null
);

create table duty_log_violation (
	uuid_ VARCHAR(75) null,
	violation_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	trainee_id LONG,
	program_master_id LONG,
	residency_level LONG,
	rotation_id LONG,
	training_site_id LONG,
	block_id LONG,
	block_week_id LONG,
	program_duty_rule_id LONG,
	acgme_80_hours_rule INTEGER,
	acgme_call_rule_option1 INTEGER,
	acgme_call_rule_option2 INTEGER,
	acgme_Short_Break_Rule INTEGER,
	acgme_24_hours_rule INTEGER,
	acgme_day_off_rule INTEGER,
	duty_log_id LONG
);

create table duty_rule_master (
	uuid_ VARCHAR(75) null,
	duty_rule_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	rule VARCHAR(75) null,
	description VARCHAR(75) null,
	parent_id LONG
);

create table duty_types_master (
	uuid_ VARCHAR(75) null,
	duty_type_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	duty_type VARCHAR(75) null,
	status VARCHAR(75) null
);

create table ec_member_request (
	uuid_ VARCHAR(75) null,
	ec_member_request_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	program_id LONG,
	potential_ec_member_id LONG,
	potential_ec_member_role_id LONG,
	latest_ec_member_request_state_id LONG,
	covering_letter_id LONG,
	cv_id LONG,
	no_objection_letter_id LONG,
	passport_copy_id LONG,
	national_id_copy_id LONG,
	qarar_request_id LONG,
	qarar_doc_id LONG,
	comments STRING null,
	potential_ec_member_lruserid LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	userName VARCHAR(75) null,
	userId LONG
);

create table ec_member_request_rotations (
	uuid_ VARCHAR(75) null,
	ec_member_request_rotations_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	ec_member_request_id LONG,
	training_site_id LONG,
	rotation_id LONG,
	is_active BOOLEAN
);

create table ec_member_request_state (
	uuid_ VARCHAR(75) null,
	ec_member_request_state_id LONG not null primary key,
	group_id LONG,
	created_by LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by_role_id LONG,
	ec_member_request_id LONG,
	ec_member_request_status_id LONG,
	comments VARCHAR(75) null,
	is_public BOOLEAN
);

create table ec_member_request_status (
	uuid_ VARCHAR(75) null,
	ec_member_request_status_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	code VARCHAR(75) null,
	name_en VARCHAR(75) null,
	name_ar VARCHAR(75) null
);

create table eligibility_degree_master (
	uuid_ VARCHAR(75) null,
	eligibility_degree_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	eligibility_degree STRING null
);

create table faculty_bank_details (
	uuid_ VARCHAR(75) null,
	faculty_bank_details_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	faculty_request_id LONG,
	bank_name STRING null,
	account_no STRING null,
	bank_branch STRING null
);

create table faculty_incentive (
	uuid_ VARCHAR(75) null,
	faculty_incentive_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	role_id LONG,
	amount_in_omr LONG,
	applicable_form DATE null
);

create table faculty_request (
	uuid_ VARCHAR(75) null,
	faculty_request_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	program_id LONG,
	potential_faculty_id LONG,
	potential_faculty_type_id LONG,
	lastest_faculty_request_state_id LONG,
	covering_letter_id LONG,
	cv_id LONG,
	passport_copy_id LONG,
	notional_id_copy_id LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);

create table faculty_request_rotations (
	uuid_ VARCHAR(75) null,
	faculty_request_rotations_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	created_by LONG,
	create_date DATE null,
	modified_date DATE null,
	modified_by LONG,
	faculty_request_id LONG,
	training_site_id LONG,
	rotation_id LONG,
	is_active BOOLEAN
);

create table faculty_request_state (
	uuid_ VARCHAR(75) null,
	faculty_request_state_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	created_by LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by_role_id LONG,
	faculty_request_id LONG,
	faculty_request_status_id LONG,
	comments VARCHAR(1000) null
);

create table faculty_request_status (
	uuid_ VARCHAR(75) null,
	faculty_request_status_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	code VARCHAR(75) null,
	name_en VARCHAR(75) null,
	name_ar VARCHAR(75) null
);

create table faculty_rotation_ts_block_details_rel (
	uuid_ VARCHAR(75) null,
	faculty_rotation_ts_block_details_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	faculty_id LONG,
	blocks_metadata_details_rel_id LONG,
	progduration_rotation_ts_rel_id LONG,
	status VARCHAR(75) null
);

create table faculty_type (
	faculty_type_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	code VARCHAR(75) null,
	name_en VARCHAR(75) null,
	name_ar VARCHAR(75) null
);

create table gender_master (
	uuid_ VARCHAR(75) null,
	gender_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	gender_name STRING null
);

create table leave_annual_master (
	uuid_ VARCHAR(75) null,
	leave_annual_master_id LONG not null primary key,
	leave_program_master_id LONG,
	leave_types_id LONG,
	training_level_id LONG,
	block_name STRING null,
	max_trainee_apply_leave INTEGER,
	no_of_trainee_taken_leave INTEGER,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table leave_annual_max_trainee (
	uuid_ VARCHAR(75) null,
	leave_annual_max_trainee_id LONG not null primary key,
	leave_annual_rule_id LONG,
	training_level STRING null,
	block INTEGER,
	week INTEGER,
	max_trainee_apply_leave INTEGER,
	no_of_trainee_taken_leave INTEGER,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table leave_annual_rule (
	uuid_ VARCHAR(75) null,
	leave_annual_rule_id LONG not null primary key,
	program_master_id LONG,
	last_date_for_submission DATE null,
	annual_leave_available_at VARCHAR(75) null,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table leave_master (
	uuid_ VARCHAR(75) null,
	leave_master_id LONG not null primary key,
	trainee_id LONG,
	leave_type_id LONG,
	leave_trainee_id LONG,
	block_name STRING null,
	leave_from DATE null,
	leave_to DATE null,
	no_of_days INTEGER,
	contact_name STRING null,
	contact_email VARCHAR(75) null,
	contact_no VARCHAR(75) null,
	reason_for_leave STRING null,
	application_date DATE null,
	return_from_leave DATE null,
	reason_for_delay STRING null,
	program_id LONG,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table leave_program_master (
	uuid_ VARCHAR(75) null,
	leave_program_master_id LONG not null primary key,
	program_master_id LONG,
	leave_types_id LONG,
	no_of_leaves INTEGER,
	resident_level_rule STRING null,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table leave_trainee_master (
	uuid_ VARCHAR(75) null,
	leave_trainee_master_id LONG not null primary key,
	leave_program_master_id LONG,
	trainee_id LONG,
	no_of_leave_taken INTEGER,
	no_of_leave_remaining INTEGER,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table leave_types (
	uuid_ VARCHAR(75) null,
	leave_types_id LONG not null primary key,
	leave_types STRING null,
	leave_code STRING null,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table level_type_master (
	uuid_ VARCHAR(75) null,
	level_type_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	level_type_name STRING null
);

create table omsb_tms_finder (
	uuid_ VARCHAR(75) null,
	omsb_tms_finder_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null
);

create table participation_type_master (
	uuid_ VARCHAR(75) null,
	participation_type_master_id LONG not null primary key,
	program_duration_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	participation_type_name STRING null
);

create table patient_type_master (
	uuid_ VARCHAR(75) null,
	patient_type_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	patient_type_name STRING null
);

create table patient_type_prog_duration_rel (
	uuid_ VARCHAR(75) null,
	patient_type_prog_duration_rel_id LONG not null primary key,
	patient_type_master_id LONG,
	program_duration_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table procedure_group_master (
	uuid_ VARCHAR(75) null,
	procedure_group_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	procedure_group_name STRING null
);

create table procedure_master (
	uuid_ VARCHAR(75) null,
	procedure_master_id LONG not null primary key,
	procedure_group_master_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	procedure_name STRING null,
	cpt_code STRING null,
	is_mandatory BOOLEAN
);

create table procedure_pg_progduration_rel (
	uuid_ VARCHAR(75) null,
	procedure_pg_pd_rel_id LONG not null primary key,
	procedure_group_master_id LONG,
	procedure_master_id LONG,
	program_duration_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG
);

create table proceduregroup_procedures_cptcode_rel (
	uuid_ VARCHAR(75) null,
	pg_procedures_cpt_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	procedure_group_id LONG,
	procedure_id LONG,
	cpt_code_id LONG
);

create table proceduregroup_progduration_rel (
	uuid_ VARCHAR(75) null,
	pg_pd_rel_id LONG not null primary key,
	procedure_group_master_id LONG,
	program_duration_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG
);

create table progduration_competencies_requirements_rel (
	uuid_ VARCHAR(75) null,
	progduration_competencies_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	prog_duration_id LONG,
	competencies_master_id LONG,
	requirements STRING null
);

create table progduration_objectives_rel (
	uuid_ VARCHAR(75) null,
	pd_objectives_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	prog_duration_id LONG,
	objectives STRING null
);

create table progduration_rotation_tl_pg_procedure_pt_rel (
	uuid_ VARCHAR(75) null,
	progduration_rotation_tl_pg_procedure_pt_rel_id LONG not null primary key,
	program_duration_id LONG,
	rotation_id LONG,
	trainee_level_id LONG,
	procedure_group_id LONG,
	procedure_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	minimum_procedures INTEGER,
	traineelevel_minimum_procedures INTEGER
);

create table progduration_rotation_traineelevel_blocks_rel (
	uuid_ VARCHAR(75) null,
	progduration_rotation_tl_blocks_rel_id LONG not null primary key,
	program_duration_id LONG,
	rotation_id LONG,
	rotation_type LONG,
	trainee_level_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	no_of_blocks INTEGER
);

create table progduration_rotation_trainingsites_rel (
	uuid_ VARCHAR(75) null,
	progduration_rotation_ts_rel_id LONG not null primary key,
	program_duration_id LONG,
	rotation_id LONG,
	training_sites_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	is_shared_rotation BOOLEAN,
	rotation_owning_program_id LONG,
	progcode_rsn_sitecode VARCHAR(75) null,
	owning_program_duration_id LONG,
	no_of_slots INTEGER
);

create table progduration_traineelevel_blocks_leveltype_rel (
	uuid_ VARCHAR(75) null,
	progduration_tl_blocks_lt_id LONG not null primary key,
	program_duration_id LONG,
	level_type_id LONG,
	trainee_level_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	no_of_blocks INTEGER
);

create table program_duration_details (
	uuid_ VARCHAR(75) null,
	prog_duration_id LONG not null primary key,
	program_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	ay_applicable_form VARCHAR(75) null,
	no_of_blocks INTEGER
);

create table program_duty_assignment (
	uuid_ VARCHAR(75) null,
	program_duty_assignment_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	program_id LONG,
	duty_assignment_id LONG,
	cohort_id LONG,
	status VARCHAR(75) null
);

create table program_duty_rule (
	uuid_ VARCHAR(75) null,
	program_duty_rule_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	program_id LONG,
	duty_rule_id LONG,
	cohort_id LONG,
	status VARCHAR(75) null
);

create table program_eligibility_degree_rel (
	uuid_ VARCHAR(75) null,
	program_ed_id LONG not null primary key,
	program_id LONG,
	eligibility_degree_master_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null
);

create table program_master (
	uuid_ VARCHAR(75) null,
	program_master_id LONG not null primary key,
	program_type_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	program_code STRING null,
	program_name STRING null,
	program_description STRING null,
	establishment_date DATE null,
	program_vision STRING null,
	program_mission STRING null,
	program_status BOOLEAN,
	program_objectives STRING null,
	program_admission_requirements STRING null
);

create table program_programtype_rel (
	uuid_ VARCHAR(75) null,
	program_pt_id LONG not null primary key,
	program_id LONG,
	program_type_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null
);

create table program_type_master (
	uuid_ VARCHAR(75) null,
	program_type_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	program_type_name STRING null
);

create table program_workflow_details_rel (
	uuid_ VARCHAR(75) null,
	program_workflow_details_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	program_id LONG,
	workflow_approval_order VARCHAR(75) null
);

create table qarar_request_info (
	uuid_ VARCHAR(75) null,
	qarar_request_id LONG not null primary key,
	reference_id LONG,
	reference_class VARCHAR(75) null,
	qarar_type VARCHAR(75) null,
	doc_tree_id LONG,
	doc_url VARCHAR(75) null,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	qarar_doc_id LONG
);

create table role_type_master (
	uuid_ VARCHAR(75) null,
	role_type_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	role_type_name STRING null
);

create table role_type_prog_duration_rel (
	uuid_ VARCHAR(75) null,
	role_type_prog_duration_rel_id LONG not null primary key,
	role_type_master_id LONG,
	program_duration_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table rotation_competencies_requirements_rel (
	uuid_ VARCHAR(75) null,
	rotation_competencies_rel_id LONG not null primary key,
	prog_duration_id LONG,
	rotation_id LONG,
	competencies_master_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	requirements STRING null
);

create table rotation_master (
	uuid_ VARCHAR(75) null,
	rotation_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	rotation_code STRING null,
	rotation_short_name STRING null,
	rotation_name STRING null,
	rotation_status BOOLEAN,
	rotation_objecctives STRING null
);

create table rotation_objectives_rel (
	uuid_ VARCHAR(75) null,
	rotation_objectives_rel_id LONG not null primary key,
	prog_duration_id LONG,
	rotation_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	objectives STRING null
);

create table rotation_type_master (
	uuid_ VARCHAR(75) null,
	rotation_type_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	rotation_type_name STRING null
);

create table shared_rotation_approver_details (
	uuid_ VARCHAR(75) null,
	shared_rotation_approver_details_id LONG not null primary key,
	shared_rotation_request_details_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	status VARCHAR(75) null,
	approved_trainees LONG,
	rejected_trainees LONG,
	approvers_comment STRING null,
	decision_making_date DATE null
);

create table shared_rotation_request_details (
	uuid_ VARCHAR(75) null,
	shared_rotation_request_details_id LONG not null primary key,
	program_duration_id LONG,
	rotation_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	no_of_trainees_requested LONG,
	requester_comment STRING null,
	status VARCHAR(75) null,
	approved_count LONG,
	rejected_count LONG,
	request_raised_to VARCHAR(75) null,
	request_raised_by VARCHAR(75) null
);

create table trainee_admission_details_rel (
	uuid_ VARCHAR(75) null,
	trainee_admission_details_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	trainee_id LONG,
	program_duration_id LONG,
	admission_year VARCHAR(75) null,
	omsb_number VARCHAR(75) null,
	trainee_address STRING null
);

create table trainee_cohort_details (
	uuid_ VARCHAR(75) null,
	trainee_cohort_details_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	trainee_admission_details_rel_id LONG,
	cohort_year VARCHAR(75) null,
	is_current_cohort BOOLEAN,
	trainee_level_id LONG,
	is_current_trainee_level BOOLEAN
);

create table trainee_electiverotation_priority_details (
	uuid_ VARCHAR(75) null,
	trainee_electiverotation_priority_details_id LONG not null primary key,
	trainee_pd_tl_er_details_id LONG,
	rotation_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	sequence INTEGER
);

create table trainee_level_master (
	uuid_ VARCHAR(75) null,
	trainee_level_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	trainee_level_name STRING null
);

create table trainee_logged_procedure_details (
	uuid_ VARCHAR(75) null,
	trainee_logged_procedure_details_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	program_duration_id LONG,
	rotation_id LONG,
	trainee_level_id LONG,
	procedure_group_id LONG,
	procedure_id LONG,
	gender_id LONG,
	patient_type_id LONG,
	visit_type_id LONG,
	cpt_code STRING null,
	training_sites_id LONG,
	role_type_id LONG,
	faculty_id LONG,
	trainee_id LONG,
	patient_id VARCHAR(75) null,
	patient_dob DATE null,
	procedure_performed_date DATE null,
	diagnosis_description STRING null,
	trainee_comments STRING null,
	supervisor_comments STRING null,
	procedure_status VARCHAR(75) null
);

create table trainee_progduration_traineelevel_details (
	uuid_ VARCHAR(75) null,
	trainee_pd_tl_er_details_id LONG not null primary key,
	trainee_id LONG,
	program_duration_id LONG,
	trainee_level_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);

create table trainee_rotation_ts_block_details_rel (
	uuid_ VARCHAR(75) null,
	trainee_rotation_ts_block_details_rel_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	created_by LONG,
	modified_by LONG,
	trainee_id LONG,
	blocks_metadata_details_rel_id LONG,
	progduration_rotation_ts_rel_id LONG,
	trainee_cohort_details_id LONG,
	rotation_status VARCHAR(75) null,
	status VARCHAR(75) null
);

create table trainee_sponsor_details (
	uuid_ VARCHAR(75) null,
	trainee_sponsor_details_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	created_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	trainee_id LONG,
	program_duration_Id LONG,
	sponsor STRING null
);

create table training_sites_master (
	uuid_ VARCHAR(75) null,
	training_site_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	modified_date DATE null,
	training_site_name STRING null,
	training_site_code STRING null,
	training_site_status BOOLEAN,
	training_site_address STRING null,
	training_site_description STRING null
);

create table violation_update_status (
	uuid_ VARCHAR(75) null,
	violation_update_status_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	created_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	blocks_metadata_details_rel_id LONG,
	status BOOLEAN
);

create table visit_type_master (
	uuid_ VARCHAR(75) null,
	visit_type_master_id LONG not null primary key,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG,
	visit_type_name STRING null
);

create table visit_type_prog_duration_rel (
	uuid_ VARCHAR(75) null,
	visit_type_prog_duration_rel_id LONG not null primary key,
	visit_type_master_id LONG,
	program_duration_id LONG,
	group_id LONG,
	company_id LONG,
	create_date DATE null,
	created_by LONG,
	modified_date DATE null,
	modified_by LONG
);