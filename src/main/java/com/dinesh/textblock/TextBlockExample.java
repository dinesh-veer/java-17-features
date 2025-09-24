package com.dinesh.textblock;

import java.time.LocalDate;

/**

Text block  is introduced in java 14/15.
Some of the examples of it showing its usages.


Reference: https://openjdk.org/jeps/378
 **/
public class TextBlockExample {

    static  String stringLiteralsWithOld = "line1\n"+
                                            "line2\n"+
                                            "line3\n"+
                                            "lime4";

//    static String getStringLiteralsWithOld =
//            "line 1\nline 2\nline 3\n line4";

    static String stringLiteralsWithNew = """
                                        line1
                                        line2
                                        line3
                                        lime4
                                        """;

    static String stringHtmlLiteralsWithOld = "<html>\n"+
                                                "\t<body>\n" +
                                                    "\t\t<h1>Welcome to Html </h1>\n"+
                                                "\t</body>\n"+
                                            "</html>\n";

    static String stringHtmlLiteralsWithNew = """
            
                                        <html>
                                            <body>
                                                 <h1>Welcome to Html </h1>
                                           </body>
                                        </html>
                                               """;

    static String stringJsonWithOld = "{\n" +
                                    "\"firstName\" : \"Dinesh\",\n"+
                                    "\"lastName\" : \"Veer\" \n" +
                                    "}\n";

    static String stringJsonWithNew = """
            {
            "firstName" : "Dinesh",
            "lastName" : "Veer"
           }
           """;

    static String stringWithPlaceHolders = "Today date is %s";


    static String stringWithSQLWithOld = "SELECT \"FIRST_NAME\", \"LAST_NAME\" FROM \"EMPLOYEE_TABLE\"\n" +
            "WHERE \"CITY\" = 'MUMBAI'\n" +
            "ORDER BY \"EMP_ID\";\n";

    static String stringWithSQLWithNew = """
                           SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
                           WHERE "CITY" = 'MUMBAI'
                           ORDER BY "EMP_ID";
                                            """;

    public static void main(String[] args) {

        System.out.println("------------------------------------------------------");

        System.out.println("String Literals with old style : \n" +stringLiteralsWithOld);

        System.out.println("------------------------------------------------------");
        System.out.println("String Literals with new style : \n" +stringLiteralsWithNew);

        System.out.println("------------------------------------------------------");

        System.out.println("String Html Literals with old style : \n" +stringHtmlLiteralsWithOld);

        System.out.println("-------------------------------------------------------");

        System.out.println("String Html Literals with new style : \n" +stringHtmlLiteralsWithNew);

        System.out.println("-----------------------------------------------------");

        System.out.println("String Json With old style : \n" +stringJsonWithOld);

        System.out.println("-----------------------------------------------------");

        //System.out.println("String Json With new style : \n" +stringJsonWithNew.stripIndent());
        System.out.println("String Json With new style : \n" +stringJsonWithNew);

        System.out.println("-------------------------------------------------------");

        System.out.println(stringWithPlaceHolders.formatted(LocalDate.now()));

        System.out.println("-------------------------------------------------------");

        System.out.println("String SQL With old style : \n" +stringWithSQLWithOld);

        System.out.println("--------------------------------------------------------");

        System.out.println("String SQL With new style : \n" +stringWithSQLWithNew);

        System.out.println("------------------------------------------------------");

    }
}
