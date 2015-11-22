
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * Created by User on 20/11/2015.
 */
public class Traslator {

    public static void main(String[] args)
    {
        try {
            JavaLexer lexer;
            if (args.length > 0)
                lexer = new JavaLexer(new ANTLRFileStream(args[0]));
            else
                lexer = new JavaLexer(new ANTLRInputStream(System.in));

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JavaParser parser = new JavaParser(tokens);
            parser.setBuildParseTree(true);
            ParseTree tree = parser.compilationUnit();


            STGroupFile stg = new STGroupFile("Template.stg");
            stg.registerModelAdaptor(ParserRuleContext.class, new ContextModelAdapter());
            ST t = stg.getInstanceOf("compilationUnit");
            t.add("program", tree);
            System.out.println(t.render());



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
