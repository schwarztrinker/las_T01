import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    //1000000
    void executeSQL01() {
        Application application = new Application();
        application.loadRecords();

        //To Test
        assertEquals(Long.valueOf(1000000), Long.valueOf(application.executeSQL01()));
    }

    @Test
    //20752
    void executeSQL02() {
        Application application = new Application();
        application.loadRecords();

        //To Test
    }

    @Test
    //2246
    void executeSQL03() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //3013
    void executeSQL04() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //65719
    void executeSQL05() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //5,521517140773159

    void executeSQL06() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //2 , 11, 1
    void executeSQL07() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //12, 12, 9, 9, 8, 5 , 5 , 3, 3
    void executeSQL08() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //dayOfWeek	Expr1001
        //fri	142658
        //mon	142951
        //sat	142677
        //sun	143036
        //thu	142739
        //tue	142639
        //wed	143300
    void executeSQL09() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
    //destination	Expr1001
        //a	1536
        //b	1536
        //c	1533
        //d	1586
        //e	1547
        //f	1534
        //g	1550
        //h	1546
    void executeSQL10() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
        //dayOfWeek	Expr1001
        //fri	2284
        //mon	2201
        //sat	2206
        //sun	2251
        //thu	2232
        //tue	2229
        //wed	2262
    void executeSQL11() {
        Application application = new Application();
        application.loadRecords();

        //to Test

    }

    @Test
    //type	Expr1001
        //m	5503
        //r	5565
        //s	5546
        //w	5639
    void executeSQL12() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
        //serviceDesk	Expr1001
        //1	313465
        //2	304900
        //3	317270
        //4	318455
        //5	309630
        //6	312325
        //7	290420
        //8	312695
        //9	301245
        //10	319520
        //11	297555
        //12	299935
    void executeSQL13() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }

    @Test
        //shift	Expr1001
        //1	5,50086680574736
        //4	5,4905296051177
    void executeSQL14() {
        Application application = new Application();
        application.loadRecords();

        //to Test
    }


}