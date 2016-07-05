package api.undercurrent.iface.editorTypes;
/**
 * Created by Niel on 10/16/2015.
 */
public class StringEditorType extends EditorType {

    private int minLength;
    private int maxLength;

    public StringEditorType(String fieldName, String fieldValue, String displayName, String displayDescription, int minLength, int maxLength) {
        super(EditorTypes.STRING);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.displayName = displayName;
        this.displayDescription = displayDescription;
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return (String) fieldValue;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void validateValue() throws Exception {

        if (getFieldValue().length() > getMaxLength()) {
            throw new Exception("UnderCurrentBlocks: StringEditorType with fieldName " + getFieldName() + " has a length of " + getFieldValue().length() + ", and max defined length is " + getMaxLength() + ".");
        }

        if (getFieldValue().length() < getMinLength()) {
            throw new Exception("UnderCurrentBlocks: StringEditorType with fieldName " + getFieldName() + " has a length of " + getFieldValue().length() + ", and min defined length is " + getMinLength() + ".");
        }

    }
}