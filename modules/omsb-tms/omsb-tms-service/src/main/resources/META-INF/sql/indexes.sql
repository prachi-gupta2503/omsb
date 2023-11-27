create index IX_99F02BE8 on bank_details (ec_member_request_id);
create index IX_2F7FF7A0 on bank_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_DD085F1E on bank_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_18876774 on block_week_metadata_details_rel (blocks_metadata_details_rel_id);
create index IX_1440D45A on block_week_metadata_details_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_E7ED2258 on block_week_metadata_details_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_79A5F97F on blocks_metadata_details_rel (progduration_tl_blocks_lt_id, block_start_date);
create index IX_178BD57A on blocks_metadata_details_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_1E45EB78 on blocks_metadata_details_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_EED41F59 on competencies_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_88852117 on competencies_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_4AA9CD13 on cpt_code_master (cpt_code_name[$COLUMN_LENGTH:75$]);
create index IX_F8FC1CA3 on cpt_code_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_163FE8E1 on cpt_code_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_1CA0823D on duty_assignment_master (duty_type_id, assignment[$COLUMN_LENGTH:75$]);
create index IX_ED778522 on duty_assignment_master (duty_type_id, status[$COLUMN_LENGTH:75$]);
create index IX_C5D93374 on duty_assignment_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_52667FF2 on duty_assignment_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_EC8B8E0A on duty_log (blocks_metadata_details_rel_id);
create index IX_EADC4654 on duty_log (program_duty_assignment_id);
create index IX_CC049690 on duty_log (trainee_id, blocks_metadata_details_rel_id);
create index IX_A8A81DA on duty_log (trainee_id, program_duty_assignment_id);
create index IX_B49FDE86 on duty_log (trainee_id, start_date);
create index IX_D1D3B204 on duty_log (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_650F6282 on duty_log (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_1D390588 on duty_log_violation (duty_log_id);
create index IX_710B5D50 on duty_log_violation (trainee_id, block_id, program_master_id, duty_log_id);
create index IX_D10197DE on duty_log_violation (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_AE50F6DC on duty_log_violation (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_1DAC51E3 on duty_rule_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_B7FC6E21 on duty_rule_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_65A4542 on duty_types_master (duty_type[$COLUMN_LENGTH:75$], status[$COLUMN_LENGTH:75$]);
create index IX_A9F7366E on duty_types_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_D23CF96C on duty_types_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_216FAA25 on ec_member_request (potential_ec_member_id);
create index IX_AF708DF6 on ec_member_request (potential_ec_member_lruserid);
create index IX_8AC89AB4 on ec_member_request (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_9E86B732 on ec_member_request (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_3E39BFCA on ec_member_request_rotations (ec_member_request_id);
create index IX_6E77BEFE on ec_member_request_rotations (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_3B6665FC on ec_member_request_rotations (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_39DDEDE8 on ec_member_request_state (ec_member_request_id, is_public);
create index IX_D9D0C6A2 on ec_member_request_state (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_CBE506A0 on ec_member_request_state (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_40AC0EED on ec_member_request_status (code[$COLUMN_LENGTH:75$]);
create index IX_86630301 on ec_member_request_status (name_en[$COLUMN_LENGTH:75$]);
create index IX_13366239 on ec_member_request_status (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_4C5A9BF7 on ec_member_request_status (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_6709F3B on eligibility_degree_master (eligibility_degree[$COLUMN_LENGTH:75$]);
create index IX_73F9875C on eligibility_degree_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_CCDAADDA on eligibility_degree_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_778A2EFA on faculty_bank_details (faculty_request_id);
create index IX_B279C085 on faculty_bank_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_A9391D43 on faculty_bank_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_52DD575E on faculty_incentive (role_id);
create index IX_5499BA2F on faculty_incentive (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_C37F796D on faculty_incentive (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_3CBD00C5 on faculty_request (potential_faculty_id);
create index IX_EB98D64B on faculty_request (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_608EEC89 on faculty_request (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_A5F3D2C1 on faculty_request_rotations (faculty_request_id, is_active);
create index IX_935FA9D5 on faculty_request_rotations (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_6291A93 on faculty_request_rotations (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_25BEC008 on faculty_request_state (faculty_request_id, created_by);
create index IX_A215B4F9 on faculty_request_state (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_8C6F9EB7 on faculty_request_state (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_22DA87C4 on faculty_request_status (code[$COLUMN_LENGTH:75$]);
create index IX_84618452 on faculty_request_status (name_ar[$COLUMN_LENGTH:75$]);
create index IX_846346CA on faculty_request_status (name_en[$COLUMN_LENGTH:75$]);
create index IX_538F3EC2 on faculty_request_status (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_9D2306C0 on faculty_request_status (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_45C4FE2 on faculty_rotation_ts_block_details_rel (blocks_metadata_details_rel_id, progduration_rotation_ts_rel_id);
create index IX_4335B7A6 on faculty_rotation_ts_block_details_rel (faculty_id, status[$COLUMN_LENGTH:75$]);
create index IX_2DF6856B on faculty_rotation_ts_block_details_rel (progduration_rotation_ts_rel_id);
create index IX_DB63EB4F on faculty_rotation_ts_block_details_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_B363728D on faculty_rotation_ts_block_details_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_6A93511C on faculty_type (code[$COLUMN_LENGTH:75$]);
create index IX_DD301BFA on faculty_type (name_ar[$COLUMN_LENGTH:75$]);
create index IX_DD31DE72 on faculty_type (name_en[$COLUMN_LENGTH:75$]);

create index IX_EBF447DF on gender_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_1281B31D on gender_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_57BAF485 on leave_annual_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_55375143 on leave_annual_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_1756B3AA on leave_annual_max_trainee (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_FE9295A8 on leave_annual_max_trainee (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_7A3A362B on leave_annual_rule (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_5DC6C469 on leave_annual_rule (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_A5BB8036 on leave_master (trainee_id);
create index IX_AF0EB6D5 on leave_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_6C376793 on leave_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_3262C97F on leave_program_master (program_master_id, leave_types_id);
create index IX_AC3A6B9A on leave_program_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_A3E38998 on leave_program_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_DAC20BBE on leave_trainee_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_CB5CE2BC on leave_trainee_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_AA5E192E on leave_types (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_607D8C2C on leave_types (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_F0288013 on level_type_master (level_type_name[$COLUMN_LENGTH:75$]);
create index IX_F9D38E33 on level_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_86667E71 on level_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_2C9417E2 on omsb_tms_finder (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_FDCBA7E0 on omsb_tms_finder (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_C8F885C8 on participation_type_master (participation_type_name[$COLUMN_LENGTH:75$], program_duration_id);
create index IX_8CFFAAC on participation_type_master (program_duration_id);
create index IX_9E98816 on participation_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_92679514 on participation_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_3127FFB3 on patient_type_master (patient_type_name[$COLUMN_LENGTH:75$]);
create index IX_67E8F2D2 on patient_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_697A7ED0 on patient_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_335E32EE on patient_type_prog_duration_rel (program_duration_id, patient_type_master_id);
create index IX_3AFADD97 on patient_type_prog_duration_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_72256D5 on patient_type_prog_duration_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_E359F6BF on procedure_group_master (procedure_group_name[$COLUMN_LENGTH:75$]);
create index IX_A4503831 on procedure_group_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_83618FEF on procedure_group_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_EC213F88 on procedure_master (procedure_group_master_id);
create index IX_4593287D on procedure_master (procedure_name[$COLUMN_LENGTH:75$], procedure_group_master_id);
create index IX_EE4CE8F1 on procedure_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_C25370AF on procedure_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_169A06F2 on procedure_pg_progduration_rel (procedure_group_master_id);
create index IX_2BD7A6B2 on procedure_pg_progduration_rel (procedure_master_id);
create index IX_44B86A71 on procedure_pg_progduration_rel (program_duration_id, procedure_group_master_id, procedure_master_id);
create index IX_8D0BA5B on procedure_pg_progduration_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_37909499 on procedure_pg_progduration_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_2D309F03 on proceduregroup_procedures_cptcode_rel (procedure_group_id);
create index IX_13D3507D on proceduregroup_procedures_cptcode_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_51264B3B on proceduregroup_procedures_cptcode_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_9CB4EBDB on proceduregroup_progduration_rel (procedure_group_master_id);
create index IX_40B16602 on proceduregroup_progduration_rel (program_duration_id, procedure_group_master_id);
create index IX_66CF9844 on proceduregroup_progduration_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_C84FD8C2 on proceduregroup_progduration_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_5DFFE042 on progduration_competencies_requirements_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_464E0840 on progduration_competencies_requirements_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_72C53FFA on progduration_objectives_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_15D7F5F8 on progduration_objectives_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_712F4C5C on progduration_rotation_tl_pg_procedure_pt_rel (procedure_group_id);
create index IX_CFED89DC on progduration_rotation_tl_pg_procedure_pt_rel (procedure_id);
create index IX_A908FBBD on progduration_rotation_tl_pg_procedure_pt_rel (program_duration_id, procedure_group_id, procedure_id, rotation_id, trainee_level_id);
create index IX_370D1404 on progduration_rotation_tl_pg_procedure_pt_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_2D394482 on progduration_rotation_tl_pg_procedure_pt_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_4BA5318A on progduration_rotation_traineelevel_blocks_rel (program_duration_id, rotation_id);
create index IX_5ADDE02B on progduration_rotation_traineelevel_blocks_rel (trainee_level_id, program_duration_id, rotation_id);
create index IX_EB0E5411 on progduration_rotation_traineelevel_blocks_rel (trainee_level_id, rotation_type);
create index IX_8F175B4C on progduration_rotation_traineelevel_blocks_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_383CBDCA on progduration_rotation_traineelevel_blocks_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_E3AB4C99 on progduration_rotation_trainingsites_rel (program_duration_id);
create index IX_C4C43721 on progduration_rotation_trainingsites_rel (rotation_id, is_shared_rotation);
create index IX_F3A87EDD on progduration_rotation_trainingsites_rel (rotation_owning_program_id, rotation_id, program_duration_id);
create index IX_DBAEC35A on progduration_rotation_trainingsites_rel (training_sites_id, program_duration_id);
create index IX_75B6D790 on progduration_rotation_trainingsites_rel (training_sites_id, rotation_id, program_duration_id);
create index IX_FD5A7143 on progduration_rotation_trainingsites_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_396AE581 on progduration_rotation_trainingsites_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_4E4C6AC5 on progduration_traineelevel_blocks_leveltype_rel (program_duration_id, trainee_level_id);
create index IX_D31A9C0E on progduration_traineelevel_blocks_leveltype_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_FA3D470C on progduration_traineelevel_blocks_leveltype_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_D2B8D373 on program_duration_details (program_id, ay_applicable_form[$COLUMN_LENGTH:75$]);
create index IX_4E8E49CD on program_duration_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_99EF588B on program_duration_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_826221F on program_duty_assignment (duty_assignment_id, status[$COLUMN_LENGTH:75$]);
create index IX_72CEEDEA on program_duty_assignment (program_id, cohort_id);
create index IX_892B30D2 on program_duty_assignment (program_id, duty_assignment_id, cohort_id);
create index IX_A4A7044 on program_duty_assignment (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_3CA0B0C2 on program_duty_assignment (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_C3455E1B on program_duty_rule (program_id, cohort_id);
create index IX_549AA0F5 on program_duty_rule (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_81F759B3 on program_duty_rule (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_1BE6A1AE on program_eligibility_degree_rel (program_id, eligibility_degree_master_id);
create index IX_6C5E6AC on program_eligibility_degree_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_EED6A12A on program_eligibility_degree_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_B2A2567F on program_master (program_code[$COLUMN_LENGTH:75$]);
create index IX_C4A6739D on program_master (program_name[$COLUMN_LENGTH:75$]);
create index IX_15D0E344 on program_master (program_status);
create index IX_3EA0E6D2 on program_master (program_type_id);
create index IX_FBA0122 on program_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_27DAE120 on program_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_665E6A88 on program_programtype_rel (program_id, program_type_id);
create index IX_3627A672 on program_programtype_rel (program_type_id);
create index IX_408F58C2 on program_programtype_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_1F61A0C0 on program_programtype_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_C8286513 on program_type_master (program_type_name[$COLUMN_LENGTH:75$]);
create index IX_B5626B33 on program_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_A2089B71 on program_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_40670FA7 on program_workflow_details_rel (program_id);
create index IX_ACED7E68 on program_workflow_details_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_6438F7E6 on program_workflow_details_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_A7FD9FF5 on qarar_request_info (doc_tree_id);
create index IX_D4449AB5 on qarar_request_info (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_E354C373 on qarar_request_info (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_A882E09F on role_type_master (role_type_name[$COLUMN_LENGTH:75$]);
create index IX_E0D38F81 on role_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_C0727B3F on role_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_5E94768E on role_type_prog_duration_rel (program_duration_id, role_type_master_id);
create index IX_6F06CD88 on role_type_prog_duration_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_B49B8F06 on role_type_prog_duration_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_F943E9CE on rotation_competencies_requirements_rel (rotation_id, prog_duration_id);
create index IX_6E6B9DB2 on rotation_competencies_requirements_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_6C6A61B0 on rotation_competencies_requirements_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_71E81AD5 on rotation_master (rotation_code[$COLUMN_LENGTH:75$]);
create index IX_83EC37F3 on rotation_master (rotation_name[$COLUMN_LENGTH:75$]);
create index IX_1AB6EA1A on rotation_master (rotation_status);
create index IX_6681171C on rotation_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_C7832D9A on rotation_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_404F18A6 on rotation_objectives_rel (rotation_id, prog_duration_id);
create index IX_9064508A on rotation_objectives_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_1E21EA88 on rotation_objectives_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_2D77DDAF on rotation_type_master (rotation_type_name[$COLUMN_LENGTH:75$]);
create index IX_35C0179 on rotation_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_BDF0B37 on rotation_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_6706B9B8 on shared_rotation_approver_details (shared_rotation_request_details_id);
create index IX_EE07F2D0 on shared_rotation_approver_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_52B5664E on shared_rotation_approver_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_561FEF6D on shared_rotation_request_details (request_raised_by[$COLUMN_LENGTH:75$]);
create index IX_191D65F4 on shared_rotation_request_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_D6155272 on shared_rotation_request_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_82352F66 on trainee_admission_details_rel (program_duration_id);
create index IX_116ED81B on trainee_admission_details_rel (trainee_id);
create index IX_B6A8A350 on trainee_admission_details_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_54C836CE on trainee_admission_details_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_213D7A64 on trainee_cohort_details (trainee_admission_details_rel_id, cohort_year[$COLUMN_LENGTH:75$], trainee_level_id);
create index IX_7C87843A on trainee_cohort_details (trainee_admission_details_rel_id, is_current_trainee_level);
create index IX_EDD8C70 on trainee_cohort_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_6164E7EE on trainee_cohort_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_21718F19 on trainee_electiverotation_priority_details (trainee_pd_tl_er_details_id);
create index IX_EC8F0BD7 on trainee_electiverotation_priority_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_E06D1515 on trainee_electiverotation_priority_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_BBDF6B0B on trainee_level_master (trainee_level_name[$COLUMN_LENGTH:75$]);
create index IX_A563384B on trainee_level_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_6D89CE89 on trainee_level_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_7DF49B9F on trainee_logged_procedure_details (patient_id[$COLUMN_LENGTH:75$]);
create index IX_FB177DC on trainee_logged_procedure_details (trainee_id);
create index IX_B5C7F86F on trainee_logged_procedure_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_8BA847AD on trainee_logged_procedure_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_46FFF236 on trainee_progduration_traineelevel_details (trainee_id, program_duration_id);
create index IX_946614A6 on trainee_progduration_traineelevel_details (trainee_id, trainee_level_id);
create index IX_EF4F4766 on trainee_progduration_traineelevel_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_9DD4E864 on trainee_progduration_traineelevel_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_E21DE8E3 on trainee_rotation_ts_block_details_rel (blocks_metadata_details_rel_id);
create index IX_AF2EEBA7 on trainee_rotation_ts_block_details_rel (progduration_rotation_ts_rel_id);
create index IX_33F073E9 on trainee_rotation_ts_block_details_rel (trainee_id, blocks_metadata_details_rel_id);
create index IX_CDACAC26 on trainee_rotation_ts_block_details_rel (trainee_id, status[$COLUMN_LENGTH:75$]);
create index IX_75A9AA8B on trainee_rotation_ts_block_details_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_3547D0C9 on trainee_rotation_ts_block_details_rel (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_A59BA6D2 on trainee_sponsor_details (trainee_id);
create index IX_CD0F28B9 on trainee_sponsor_details (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_3AB30277 on trainee_sponsor_details (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_1453BFB4 on training_sites_master (training_site_code[$COLUMN_LENGTH:75$]);
create index IX_2657DCD2 on training_sites_master (training_site_name[$COLUMN_LENGTH:75$]);
create index IX_D0CCD339 on training_sites_master (training_site_status);
create index IX_564EEA85 on training_sites_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_B450C743 on training_sites_master (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_44BC2D7D on violation_update_status (blocks_metadata_details_rel_id);
create index IX_73F5F3B1 on violation_update_status (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_10402B6F on violation_update_status (uuid_[$COLUMN_LENGTH:75$], group_id);

create index IX_3D50714C on visit_type_master (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_2DC353CA on visit_type_master (uuid_[$COLUMN_LENGTH:75$], group_id);
create index IX_326C94B3 on visit_type_master (visit_type_name[$COLUMN_LENGTH:75$]);

create index IX_E1B8846E on visit_type_prog_duration_rel (program_duration_id, visit_type_master_id);
create index IX_E9416EDD on visit_type_prog_duration_rel (uuid_[$COLUMN_LENGTH:75$], company_id);
create unique index IX_E648819B on visit_type_prog_duration_rel (uuid_[$COLUMN_LENGTH:75$], group_id);