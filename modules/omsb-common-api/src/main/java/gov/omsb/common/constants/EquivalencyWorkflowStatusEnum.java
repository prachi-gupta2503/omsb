package gov.omsb.common.constants;


import java.util.HashMap;
import java.util.Map;

public enum EquivalencyWorkflowStatusEnum {
	DEFAULT(0,"completed","omsb-created-bg"),
	CREATED(1,"created","omsb-created-bg"), 
	RESUBMIT(2,"insufficient","omsb-insufficient-bg"),
	INITIATE(3,"initiated","omsb-initiated-bg"),
	EQUATE(4,"equated","omsb-equated-bg"),
	COMPLETE(5,"completed","omsb-created-bg"); 
	
	private final Integer value;
    private final String text;
    private final String color;
    
    private static Map<Integer, EquivalencyWorkflowStatusEnum> valueToTextMapping;
    private static Map<String, EquivalencyWorkflowStatusEnum> textToEnumMapping;

    private EquivalencyWorkflowStatusEnum(Integer value, String text, String color){
        this.value = value;
        this.text = text;
        this.color = color;
    }

    public static EquivalencyWorkflowStatusEnum getStatus(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }
    
    public static EquivalencyWorkflowStatusEnum getStatusByLabel(String label){
        if(textToEnumMapping == null){
            initTextToEnumMapping();
        }
        return textToEnumMapping.get(label);
    }

    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(EquivalencyWorkflowStatusEnum s : values()){
            valueToTextMapping.put(s.value, s);
        }
    }
    
    private static void initTextToEnumMapping(){
    	textToEnumMapping = new HashMap<>();
        for(EquivalencyWorkflowStatusEnum s : values()){
        	textToEnumMapping.put(s.text, s);
        }
    }
    

    public Integer getValue(){
        return value;
    }

    public String getText(){
        return text;
    }
    
    public String getColor(){
        return color;
    }
    
    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append("ServiceTicketStatus");
        sb.append("{value=").append(value);
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
