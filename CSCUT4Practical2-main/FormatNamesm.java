import java.io.*;
import java.util.*;




/**
 *
 * CSCU9T4 Java strings and files exercise.
 *@author Nabeel
 */

public class FormatNamesm {
    public static void main(String[] args) {

        // Initializing variables for input and output files
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        boolean UpperCase = false;

       // Checks whether the names of the files are provided
        if (args.length >= 2) {
            inputFile = args[0];
            outputFile = args[1];
        }

       // Third argument checking '-u'
        if (args.length >= 3 && args[2].equals("-u")) {
            UpperCase = true;
        }

       // Sets up a new scanner
        try {
            File file = new File(inputFile);
            Scanner sc= new Scanner(file);
            // New printwriter for o/p writing
            PrintWriter writer = new PrintWriter(outputFile);

          // Line By Line processing
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) { 
                    String[] index = line.split("\\s+");
                    String firstName = "";
                    String middleName = "";
                    String lastName = "";
                    if (index.length == 3) {
                        firstName = Format_Name(index[0], UpperCase );
                        middleName = FormatMiddleInitial(index[1]);
                        lastName = Format_Name(index[2],UpperCase );
                    } else if (index.length == 2) {
                        firstName = Format_Name(index[0],UpperCase );
                        lastName = Format_Name(index[1], UpperCase );
                    }
                    String dateOfBirth =  formatDate(index[2]);
                    writer.println(firstName + " " + middleName + " " + lastName + " " + dateOfBirth + ".");
                }
            }
            sc.close();
            writer.close();


                } catch (FileNotFoundException e) {
                    System.err.println("File not found: " + e.getMessage());
                }
            }


/**
 * Formats name to title case or Uppercase.
 * @param Name Name to format.
 * @param UpperCase Boolean Parameter if true to UpperCase if not to TitleCase.
 * @return Formatted name.
 */

            public static String Format_Name(String Name, boolean UpperCase) {
                String format = "";
                if (UpperCase)
                {
                    format = Name.toUpperCase();
                } else
                {
                    format = Name.substring(0, 1).toUpperCase() + Name.substring(1).toLowerCase();
                }
                return format;
            }
    /**
     * Format middle name to TitleCase or UpperCase and adds a fullstop.
     * @param Name Middle name to format.
     * @return Formatted middle name.
     */
    public static String FormatMiddleInitial(String Name) {
        String format = "";
        if (Name.length() > 0) {
            format = Name.substring(0, 1).toUpperCase() + ".";
        }
        return format;
    }


/**
 * Format the date in "dd/mm/yyyy" format.
 * @param Date Date to format in the format "ddmmyyyy".
 * @return Formatted date.
 */

            public static String formatDate(String Date)
            {
                String format= Date.substring(0, 2) + "/" + Date.substring(2, 4) + "/" + Date.substring(4);
                return format;
            }

        }


// FilesInOut