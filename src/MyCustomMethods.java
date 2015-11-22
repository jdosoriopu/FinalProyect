/**
 * Created by User on 21/11/2015.
 */
public class MyCustomMethods {

    public static boolean ContainsFinalImport(Object o)
    {
        return  (((JavaParser.ImportDeclarationContext)o).getText().contains("*"));
    }

    public static boolean InheritedClass(Object o)
    {
        return (((JavaParser.ClassDeclarationContext)o).getText().contains("extends"));
    }

    public static boolean ImplementedClass(Object o)
    {
        return (((JavaParser.ClassDeclarationContext)o).getText().contains("implements"));
    }
}