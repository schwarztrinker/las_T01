import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Application {
    private List<Record> records = new ArrayList<>();

    public List<Record> loadRecords() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data\\records.csv"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] entries = line.split(";");
                Ticket ticket = new Ticket(entries[5], entries[6], Integer.parseInt(entries[7]));
                records.add(new Record(Integer.parseInt(entries[0]), Integer.parseInt(entries[1]), Integer.parseInt(entries[2]), Integer.parseInt(entries[3]),entries[4], ticket, entries[8]));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            return records;
        }

    }

    // count
    public long executeSQL01() {
        System.out.println("--- query 01 (count)");
        System.out.println("SELECT COUNT(*) FROM data");
        System.out.println(records.stream().count());

        return records.stream().count();
    }

    // count, where
    public long executeSQL02() {
        System.out.println("");
        System.out.println("--- query 02 (count, where)");
        System.out.println("SELECT COUNT(*) FROM data WHERE serviceDesk = 8 AND type = 'w'");
        System.out.println(
                records
                        .stream()
                        .filter(s -> s.getServiceDesk() == 8)
                        .filter(s -> s.getTicket().getType().equals("w"))
                .count()
        );

        return records
                .stream()
                .filter(s -> s.getServiceDesk() == 8)
                .filter(s -> s.getTicket().getType().equals("w"))
                .count();
    }

    // count, where, in
    public long executeSQL03() {
        System.out.println("");
        System.out.println("--- query 03 (count, where, in)");
        System.out.println("SELECT COUNT(*) FROM data WHERE serviceDesk = 4 AND shift = 1 AND type = 'm' AND dayOfWeek IN ('fri','sat','sun')");

        return records
                .stream()
                .filter(s -> s.getServiceDesk() == 4)
                .filter(s -> s.getShift() == 1)
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> s.getDayOfWeek().equals("fri") || s.getDayOfWeek().equals("sat") || s.getDayOfWeek().equals("sun"))
                .count();

    }

    // count, where, not in
    public long executeSQL04() {
        System.out.println("");
        System.out.println("--- query 04 (count, where, not in)");
        System.out.println("SELECT COUNT(*) FROM data WHERE serviceDesk = 8 AND shift = 2 AND type = 'r' AND dayOfWeek NOT IN ('mon','fri','sat')");
        System.out.println(records
                .stream()
                .filter(s -> s.getServiceDesk() == 8)
                .filter(s -> s.getShift() == 2)
                .filter(s -> s.getTicket().getType().equals("r"))
                .filter(s -> !(s.getDayOfWeek().equals("mon") || s.getDayOfWeek().equals("fri") || s.getDayOfWeek().equals("sat")))
                .count());

        return records
                .stream()
                .filter(s -> s.getServiceDesk() == 8)
                .filter(s -> s.getShift() == 2)
                .filter(s -> s.getTicket().getType().equals("r"))
                .filter(s -> !(s.getDayOfWeek().equals("mon") || s.getDayOfWeek().equals("fri") || s.getDayOfWeek().equals("sat")))
                .count();
    }

    // id, where, in, order by desc limit
    public long executeSQL05() {
        System.out.println("");
        System.out.println("--- query 05 (sum, where, in)");
        System.out.println("SELECT SUM(waitingTimeInMinutes) FROM data WHERE serviceDesk IN (1,2,7,8) AND shift = 1 AND type IN ('s','r') AND dayOfWeek IN ('sat','sun')");
        System.out.println(records
                .stream()
                .filter(s -> s.getServiceDesk() == 1 || s.getServiceDesk() == 2 || s.getServiceDesk() == 7 || s.getServiceDesk() == 8 )
                .filter(s -> s.getShift() == 1)
                .filter(s -> s.getTicket().getType().equals("r") || s.getTicket().getType().equals("s"))
                .filter(s -> s.getDayOfWeek().equals("sat") ||s.getDayOfWeek().equals("sun") )
                .mapToInt(s -> s.getWaitingTimeInMinutes())
                        .sum()
                );

        return records
                .stream()
                .filter(s -> s.getServiceDesk() == 1 || s.getServiceDesk() == 2 || s.getServiceDesk() == 7 || s.getServiceDesk() == 8 )
                .filter(s -> s.getShift() == 1)
                .filter(s -> s.getTicket().getType().equals("r") || s.getTicket().getType().equals("s"))
                .filter(s -> s.getDayOfWeek().equals("sat") ||s.getDayOfWeek().equals("sun") )
                .mapToInt(s -> s.getWaitingTimeInMinutes())
                .sum();
    }

    // id, where, in, order by desc, order by asc
    public double executeSQL06() {
        //"SELECT AVG(waitingTimeInMinutes) FROM data WHERE serviceDesk IN (1,2,3) AND shift IN (1,4) AND type = 'm' AND dayOfWeek NOT IN ('mon','fri')"
        System.out.println("");
        System.out.println("--- query 06 (avg, where, not in)");
        System.out.println("SELECT AVG(waitingTimeInMinutes) FROM data WHERE serviceDesk IN (1,2,3) AND shift IN (1,4) AND type = 'm' AND dayOfWeek NOT IN ('mon','fri')");
        System.out.println( records.stream()
                .filter(s -> s.getServiceDesk() == 1 || s.getServiceDesk() == 2 || s.getServiceDesk() == 3)
                .filter(s -> s.getShift() == 1 ||s.getShift() == 4 )
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> !(s.getDayOfWeek().equals("mon") || s.getDayOfWeek().equals("fri")))
                .mapToDouble(s -> s.getWaitingTimeInMinutes()).average().getAsDouble()
        );

        return records.stream()
                .filter(s -> s.getServiceDesk() == 1 || s.getServiceDesk() == 2 || s.getServiceDesk() == 3)
                .filter(s -> s.getShift() == 1 ||s.getShift() == 4 )
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> !(s.getDayOfWeek().equals("mon") || s.getDayOfWeek().equals("fri")))
                .mapToDouble(s -> s.getWaitingTimeInMinutes()).average().getAsDouble();
    }

    // count, group by
    public List<Integer> executeSQL07() {
        //"SELECT serviceDesk FROM data WHERE shift = 2 AND type = 'r' AND dayOfWeek IN ('sat','sun') AND destination = 'b' AND waitingTimeInMinutes = 10 ORDER BY dayOfWeek DESC LIMIT 3"
        System.out.println("");
        System.out.println("--- query 07 (id, where, in, order by desc limit)");
        System.out.println("SELECT serviceDesk FROM data WHERE shift = 2 AND type = 'r' AND dayOfWeek IN ('sat','sun') AND destination = 'b' AND waitingTimeInMinutes = 10 ORDER BY dayOfWeek DESC LIMIT 3");
        System.out.println(records.stream()
                .filter(s -> s.getShift() == 2)
                .filter(s -> s.getTicket().getType().equals("r"))
                .filter(s -> s.getDayOfWeek().equals("sat") || s.getDayOfWeek().equals("sun"))
                .filter(s -> s.getTicket().getDestination().equals("b"))
                .filter(s -> s.getWaitingTimeInMinutes() == 10)
                .sorted(Comparator.comparing(Record::getDayOfWeek).reversed())
                .limit(3)
                .map(s -> s.getServiceDesk())
                .collect(Collectors.toList()));

        return records.stream()
                .filter(s -> s.getShift() == 2)
                .filter(s -> s.getTicket().getType().equals("r"))
                .filter(s -> s.getDayOfWeek().equals("sat") || s.getDayOfWeek().equals("sun"))
                .filter(s -> s.getTicket().getDestination().equals("b"))
                .filter(s -> s.getWaitingTimeInMinutes() == 10)
                .sorted(Comparator.comparing(Record::getDayOfWeek).reversed())
                .limit(3)
                .map(s -> s.getServiceDesk())
                .collect(Collectors.toList());
    }

    // count, where, group by
    public List<Integer> executeSQL08() {
        // "SELECT serviceDesk FROM data WHERE shift = 1 AND type = 'm' AND dayOfWeek = 'mon' AND destination IN ('a','f') AND waitingTimeInMinutes = 10 AND premiumService = 'yes' ORDER BY serviceDesk DESC, destination"
        System.out.println("");
        System.out.println("--- query 08 (id, where, in, order by desc, order by asc)");
        System.out.println("SELECT serviceDesk FROM data WHERE shift = 1 AND type = 'm' AND dayOfWeek = 'mon' AND destination IN ('a','f') AND waitingTimeInMinutes = 10 AND premiumService = 'yes' ORDER BY serviceDesk DESC, destination");
        System.out.println(records.stream()
                .filter(s -> s.getShift() == 1)
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> s.getDayOfWeek().equals("mon"))
                .filter(s -> s.getTicket().getDestination().equals("a") || s.getTicket().getDestination().equals("f") )
                .filter(s -> s.getWaitingTimeInMinutes() == 10)
                .filter(s -> s.getPremiumService().equals("yes"))
                .sorted(Comparator.comparing(Record::getServiceDesk).reversed().thenComparing(Record::getDestination))
                .map(s -> s.getServiceDesk())
                .collect(Collectors.toList())
        );

        return records.stream()
                .filter(s -> s.getShift() == 1)
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> s.getDayOfWeek().equals("mon"))
                .filter(s -> s.getTicket().getDestination().equals("a") || s.getTicket().getDestination().equals("f") )
                .filter(s -> s.getWaitingTimeInMinutes() == 10)
                .filter(s -> s.getPremiumService().equals("yes"))
                .sorted(Comparator.comparing(Record::getServiceDesk).reversed().thenComparing(Record::getDestination))
                .map(s -> s.getServiceDesk())
                .collect(Collectors.toList());


    }

    // count, where, in, group by
    public Map<String, Long> executeSQL09() {
        //"SELECT dayOfWeek,COUNT(*) FROM data GROUP BY dayOfWeek"
        System.out.println("");
        System.out.println("--- query 09 (count, group by");
        System.out.println("SELECT dayOfWeek,COUNT(*) FROM data GROUP BY dayOfWeek");
        System.out.println(records.stream()
                .collect(Collectors.groupingBy(Record::getDayOfWeek, Collectors.counting())));

        return records.stream()
                .collect(Collectors.groupingBy(Record::getDayOfWeek, Collectors.counting()));
    }

    // count, where, not in, group by
    public Map<String, Long> executeSQL10() {
        //"SELECT destination,COUNT(*) FROM data WHERE type = 'm' AND premiumService = 'yes' GROUP BY destination"
        System.out.println("");
        System.out.println("--- query 10 (count, where, group by)");
        System.out.println("SELECT destination,COUNT(*) FROM data WHERE type = 'm' AND premiumService = 'yes' GROUP BY destination");
        System.out.println(records.stream()
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> s.getPremiumService().equals("yes"))
                .collect(Collectors.groupingBy(Record::getDestination, Collectors.counting())));


        return records.stream()
                .filter(s -> s.getTicket().getType().equals("m"))
                .filter(s -> s.getPremiumService().equals("yes"))
                .collect(Collectors.groupingBy(Record::getDestination, Collectors.counting()));

    }

    // sum, where, not in, in, group by
    public Map<String, Long> executeSQL11() {
        //"SELECT dayOfWeek,COUNT(*) FROM data WHERE shift = 3 AND destination = 'c'  AND type IN ('s','r') GROUP BY dayOfWeek"
        System.out.println("");
        System.out.println("--- query 11 (count, where, in, group by)");
        System.out.println("SELECT dayOfWeek,COUNT(*) FROM data WHERE shift = 3 AND destination = 'c'  AND type IN ('s','r') GROUP BY dayOfWeek");
        System.out.println(records.stream()
                .filter(s -> s.getShift() == 3)
                .filter(s -> s.getTicket().getDestination().equals("c"))
                .filter(s -> s.getTicket().getType().equals("s") || s.getTicket().getType().equals("r"))
                .collect(Collectors.groupingBy(Record::getDayOfWeek, Collectors.counting())));


        return records.stream()
                .filter(s -> s.getShift() == 3)
                .filter(s -> s.getTicket().getDestination().equals("c"))
                .filter(s -> s.getTicket().getType().equals("s") || s.getTicket().getType().equals("r"))
                .collect(Collectors.groupingBy(Record::getDayOfWeek, Collectors.counting()));



    }

    // avg, where, in, in, group by
    public Map<String, Long> executeSQL12() {

        //"SELECT type,COUNT(*) FROM data WHERE destination = 'b' AND shift = '4' AND dayOfWeek NOT IN ('tue','wed') GROUP BY type"

        System.out.println("");
        System.out.println("--- query 12 (count, where, not in, group by)");
        System.out.println("SELECT type,COUNT(*) FROM data WHERE destination = 'b' AND shift = '4' AND dayOfWeek NOT IN ('tue','wed') GROUP BY type");
        System.out.println(records.stream()
                .filter(s -> s.getTicket().getDestination().equals("b"))
                .filter(s -> s.getShift() == 4)
                .filter(s -> !(s.getDayOfWeek().equals("tue") || s.getDayOfWeek().equals("wed")))
                .collect(Collectors.groupingBy(Record::getType, Collectors.counting())));

        return records.stream()
                .filter(s -> s.getTicket().getDestination().equals("b"))
                .filter(s -> s.getShift() == 4)
                .filter(s -> !(s.getDayOfWeek().equals("tue") || s.getDayOfWeek().equals("wed")))
                .collect(Collectors.groupingBy(Record::getType, Collectors.counting()));

    }

    public Map<Integer, Integer> executeSQL13(){

        //"SELECT serviceDesk,SUM(price) FROM data WHERE type NOT IN ('s','r') AND shift IN (1,2) AND premiumService = 'yes' GROUP BY serviceDesk"

        System.out.println("");
        System.out.println("--- query 13 (sum, where, not in, in, group by)");
        System.out.println("SELECT serviceDesk,SUM(price) FROM data WHERE type NOT IN ('s','r') AND shift IN (1,2) AND premiumService = 'yes' GROUP BY serviceDesk");
        System.out.println(records.stream()
                .filter(s -> !(s.getType().equals("s") || s.getType().equals("r")))
                .filter(s -> s.getShift() == 1 || s.getShift() == 2)
                .filter(s -> s.getPremiumService().equals("yes"))
                .collect(Collectors.groupingBy(Record::getServiceDesk, Collectors.summingInt(Record::getPrice)))
        );

        return records.stream()
                .filter(s -> !(s.getType().equals("s") || s.getType().equals("r")))
                .filter(s -> s.getShift() == 1 || s.getShift() == 2)
                .filter(s -> s.getPremiumService().equals("yes"))
                .collect(Collectors.groupingBy(Record::getServiceDesk, Collectors.summingInt(Record::getPrice)));

    }

    public Map<Integer, Float> executeSQL14(){
        //"SELECT shift,AVG(waitingTimeInMinutes) FROM data WHERE premiumService = 'no' AND dayOfWeek IN ('fri','mon') AND shift IN (1,4) GROUP BY shift"
        System.out.println("");
        System.out.println("--- query 14 (avg, where, in, in, group by)");
        System.out.println("SELECT shift,AVG(waitingTimeInMinutes) FROM data WHERE premiumService = 'no' AND dayOfWeek IN ('fri','mon') AND shift IN (1,4) GROUP BY shift");
        System.out.println(records.stream()
                .filter(s -> s.getPremiumService().equals("no"))
                .filter(s -> !(s.getDayOfWeek().equals("fri") || s.getDayOfWeek().equals("mon")))
                .filter(s -> s.getShift() == 1 || s.getShift() == 4)
                .collect(Collectors.groupingBy(Record::getShift, Collectors.collectingAndThen(Collectors.averagingDouble(Record::getWaitingTimeInMinutes), Double::floatValue)))
        );


        return records.stream()
                .filter(s -> s.getPremiumService().equals("no"))
                .filter(s -> !(s.getDayOfWeek().equals("fri") || s.getDayOfWeek().equals("mon")))
                .filter(s -> s.getShift() == 1 || s.getShift() == 4)
                .collect(Collectors.groupingBy(Record::getShift, Collectors.collectingAndThen(Collectors.averagingDouble(Record::getWaitingTimeInMinutes), Double::floatValue)));

    }

    public void execute() {
        loadRecords();
        executeSQL01();
        executeSQL02();
        executeSQL03();
        executeSQL04();
        executeSQL05();
        executeSQL06();
        executeSQL07();
        executeSQL08();
        executeSQL09();
        executeSQL10();
        executeSQL11();
        executeSQL12();
        executeSQL13();
        executeSQL14();

    }

    public static void main(String... args) {
        Application app = new Application();
        app.execute();


    }
}