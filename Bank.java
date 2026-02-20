import java.io.*;

class Bank {

    private static final String FILE_NAME = "accounts.txt";

    // Save account to file
    public static void saveAccount(Account acc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(acc.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

    // Search account by number
    public static Account searchAccount(int accNo) {
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int fileAccNo = Integer.parseInt(data[0]);

                if (fileAccNo == accNo) {
                    String name = data[1];
                    double balance = Double.parseDouble(data[2]);
                    return new Account(fileAccNo, name, balance);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }
}
