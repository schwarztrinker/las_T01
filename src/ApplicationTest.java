import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        assertEquals(Long.valueOf(20752), Long.valueOf(application.executeSQL02()));
    }

    @Test
    //2246
    void executeSQL03() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        assertEquals(Long.valueOf(2246), Long.valueOf(application.executeSQL03()));
    }

    @Test
    //3013
    void executeSQL04() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        assertEquals(Long.valueOf(3013), Long.valueOf(application.executeSQL04()));
    }

    @Test
    //65719
    void executeSQL05() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        assertEquals(Long.valueOf(65719), Long.valueOf(application.executeSQL05()));
    }

    @Test
    //5,521517140773159

    void executeSQL06() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        assertEquals(Double.valueOf(5.521517140773159), Double.valueOf(application.executeSQL06()));
    }

    @Test
    //2 , 11, 1
    void executeSQL07() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(9);
        list.add(8);
        assertEquals(list, application.executeSQL07());

    }

    @Test
    //12, 12, 9, 9, 8, 5 , 5 , 3, 3
    void executeSQL08() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(12);
        list.add(9);
        list.add(9);
        list.add(8);
        list.add(5);
        list.add(5);
        list.add(3);
        list.add(3);
        assertEquals(list, application.executeSQL08());

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
        Map<String, Long> list = new HashMap<>();
        list.put("fri", 142658L);
        list.put("mon",	142951L);
        list.put("sat",	142677L);
        list.put("sun",	143036L);
        list.put("thu",	142739L);
        list.put("tue",	142639L);
        list.put("wed",	143300L);
        assertEquals(list, application.executeSQL09());
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
        Map<String, Long> list = new HashMap<>();
        list.put("a", 1536L);
        list.put("b", 1536L);
        list.put("c", 1533L);
        list.put("d", 1586L);
        list.put("e", 1547L);
        list.put("f", 1534L);
        list.put("g", 1550L);
        list.put("h", 1546L);

        assertEquals(list, application.executeSQL10());

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
        Map<String, Long> list = new HashMap<>();
        list.put("fri", 2284L);
        list.put("mon",	2201L);
        list.put("sat",	2206L);
        list.put("sun",	2251L);
        list.put("thu",	2232L);
        list.put("tue",	2229L);
        list.put("wed",	2262L);
        assertEquals(list, application.executeSQL11());


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
        Map<String, Long> list = new HashMap<>();
        list.put("m", 5503L);
        list.put("r",	5565L);
        list.put("s",	5546L);
        list.put("w",	5639L);

        assertEquals(list, application.executeSQL12());
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
        Map<Integer, Integer> list = new HashMap<>();
        list.put(1	,313465);
        list.put(2,	304900);
        list.put(3,	317270);
        list.put(4,	318455);
        list.put(5,	309630);
        list.put(6,	312325);
        list.put(7,	290420);
        list.put(8,	312695);
        list.put(9,	301245);
        list.put(10,	319520);
        list.put(11,	297555);
        list.put(12,	299935);



        assertEquals(list, application.executeSQL13());

    }

    @Test
    void executeSQL14() {
        Application application = new Application();
        application.loadRecords();

        //to Test
        Map<Integer, Float> list = new HashMap<>();
        list.put(1,	5.5037847F);
        list.put(4,	5.5088186F);


        assertEquals(list, application.executeSQL14());
    }


}