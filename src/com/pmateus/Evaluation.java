package com.pmateus;

import static com.pmateus.utils.Settings.WAIT_DELAY_SECONDS;

import com.pmateus.data.Repository;
import com.pmateus.entities.Calc;
import com.pmateus.utils.Parser;
import com.pmateus.utils.UtilsIO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Paulo Mateus
 */
public class Evaluation {

    List<File> files = new ArrayList<>();

    public void init() throws Exception {
        while (true) {
            System.out.println("Rodando...");
            ArrayList<File> neew = new ArrayList<>();
            List<Repository> repositories = new ArrayList<>();

            Parser.getFileNames(files, neew);
            for (File in : neew) {
                repositories.add(Parser.getDataFromFile(in));
            }

            //Depois de processar toda entrada, começa a processar saída.
            for (Repository in : repositories) {
                generate(in);
                generateOutput(in);;
            }

            TimeUnit.SECONDS.sleep(WAIT_DELAY_SECONDS);
        }
    }

    public void generate(Repository repository) {
        Calc calc = Calc.calculate(repository);
        repository.setCalc(calc);

        /*DEBUG*/
        System.out.println(calc.toString());
    }

    private void generateOutput(Repository in) {
        Parser.generateOutput(in);
    }
}
