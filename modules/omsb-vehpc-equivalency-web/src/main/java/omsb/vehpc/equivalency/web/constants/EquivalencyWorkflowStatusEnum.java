package omsb.vehpc.equivalency.web.constants;


import java.util.HashMap;
import java.util.Map;

public enum EquivalencyWorkflowStatusEnum {
	DEFAULT(0,"complete"),
	CREATED(1,"created"), 
	INSUFFICENT(2,"insufficient"),
	INITIATE(3,"initiate"),
	EQUATE(4,"equate"),
	COMPLETE(5,"complete"),
	RESUBMIT(6,"resubmit");
	
	private final Integer value;
    private final String text;
    
    private static Map<Integer, EquivalencyWorkflowStatusEnum> valueToTextMapping;

    private EquivalencyWorkflowStatusEnum(Integer value, String text){
        this.value = value;
        this.text = text;
    }

    public static EquivalencyWorkflowStatusEnum getStatus(Integer i){
        if(valueToTextMapping == null){
            initMapping();
        }
        return valueToTextMapping.get(i);
    }

    private static void initMapping(){
        valueToTextMapping = new HashMap<>();
        for(EquivalencyWorkflowStatusEnum s : values()){
            valueToTextMapping.put(s.value, s);
        }
    }

    public Integer getValue(){
        return value;
    }

    public String getText(){
        return text;
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
