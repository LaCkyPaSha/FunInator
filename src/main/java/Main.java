import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static List<String> texts = new ArrayList<>();

  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) {

    init();

    Random rand = new Random();

    int randomNum = rand.nextInt(texts.size());

    String text = texts.get(randomNum);

    String firstA = null;
    String secondA = null;
    String object = null;

    try {

      Pattern pattern = Pattern.compile("^[A-ZА-ЯІЄЩЇ].*");

      System.out.print("Введіть персонажа жіночого роду: ");
      boolean b = true;
      while (b) {

        firstA = reader.readLine();

        Matcher matcher = pattern.matcher(firstA);

        if (firstA.length() < 3 || !matcher.matches()) {
          System.out.println("Невірне Ім'я");
        } else {
          b = false;
        }
      }

      System.out.print("Введіть персонажа чоловічого роду: ");
      b = true;
      while (b) {

        secondA = reader.readLine();

        Matcher matcher = pattern.matcher(secondA);

        if (secondA.length() < 3 || !matcher.matches()) {
          System.out.println("Невірне Ім'я");
        } else {
          b = false;
        }
      }

      System.out.print("Введіть предмет: ");
      b = true;
      while (b) {

        object = reader.readLine();

        if (object.length() < 3) {
          System.out.println("Невірне Ім'я");
        } else {
          b = false;
        }
      }

    } catch (IOException e) {
      System.out.println("error_code_1");
    }

    text = text.replace("Оля", firstA);
    text = text.replace("Петя", secondA);
    text = text.replace("м'яч", object);

    int consoleWidth = 50; // Визначте ширину консолі або області виводу
    List<String> wrappedText = wrapText(text, consoleWidth);

    System.out.println("\nОсь згенерована для Вас історія!\n");

    try {
      for (String line : wrappedText) {
        int delayInMillis = 20; // Adjust this value to control the typing speed (in milliseconds)

        int i = 0;

        for (char c : line.toCharArray()) {
          System.out.print(c);
          Thread.sleep(delayInMillis);
          i++;
          if (i >= line.toCharArray().length) {
            System.out.println("");
          }
        }
      }
    } catch (RuntimeException | InterruptedException runtimeException) {
    }

  }

  public static List<String> wrapText(String input, int consoleWidth) {
    List<String> wrappedText = new ArrayList<>();
    String[] words = input.split("\\s+");

    StringBuilder currentLine = new StringBuilder();
    for (String word : words) {
      if (currentLine.length() + word.length() + 1 <= consoleWidth) {
        if (currentLine.length() > 0) {
          currentLine.append(" ");
        }
        currentLine.append(word);
      } else {
        wrappedText.add(currentLine.toString());
        currentLine = new StringBuilder(word);
      }
    }

    if (currentLine.length() > 0) {
      wrappedText.add(currentLine.toString());
    }

    return wrappedText;
  }

  public static void init() {

    texts.add(
        "Одного яскравого літнього дня Оля і Петя вирішили влаштувати пікнік в лісі. Оля приготувала смачний салат, а Петя відповідав за шашлики. Після веселого обіду Оля розгорнула настільний футбол, а Петя почав шукати м'яч. Але виявилося, що Петя забув взяти м'яч з собою. Оля, звісно ж, не залишалася осторонь і вирішила допомогти. Вона взяла в руки пусту бляшанку від газованої води і сказала: Не варто хвилюватися, Петя, в нашому веселому лісі може статися будь-що. Ось, ми зробимо з цієї бляшанки м'яч, і гра продовжиться! Петя спершу подивився з недовірою, але потім усміхнувся і взяв бляшанку. Вони почали грати у футбол цією річчу, і відразу ж виявили, що це найсмішніший матч їхнього життя. Під час гри м'яч випадково відскочив від дерева і влетів в кущі, і Оля та Петя почали сміятися так, що не могли зупинитися. Їхній сміх і радість заповнили ліс і здавалося, що навіть природа долучилася до їхньої гри. По закінченню дня, коли вони поверталися додому, Петя сказав: \"Той день, коли ми грали у футбол з бляшанкою як м'яч, був найсмішнішим і найвеселішим днем у моєму житті. Оля відповіла: \"Так, це був найкращий літній день. І він показав нам, що навіть найзвичайніші речі можуть приносити радість і сміх, якщо у нас є ми і гарний настрій! З цими словами вони пішли додому, тримаючись за руки, і знали, що літо принесло їм не тільки веселощі, але й незабутні спогади про цей надзвичайний день з пустою бляшанкою від газованої води як м'яч.");
    texts.add(
        "Оля і Петя завжди мріяли про часову машину, щоб відвідати різні епохи і подорожувати у часі. Одного дня, вони виявили старий, залишений на горищі годинник, який виглядав як м'яч. Вони вирішили ремонтувати його, щоб здійснити свою мрію. Спочатку вони досліджували м'яч, вивчаючи всі його деталі та механізми. Вони взяли книги з бібліотеки та вчителя з ремонту м'яч, щоб дізнатися, як відновити старий механізм. Оля була відповідальна за розібрання м'ячу, а Петя - за заміну та відновлення пошкоджених деталей. Дні і ночі вони працювали разом, використовуючи свої знання та творчість. Вони навчилися робити дрібні м'ячі та мали підручники власного виготовлення для заміни старих частин. Щоб забезпечити правильний хід м'ячу, вони провели безліч експериментів та тестів. Після тривалого робочого процесу настав момент істини. Оля і Петя увімкнули реставрований м'яч. Це був момент їхньої великої перемоги! Часова машина була відновлена. Оля і Петя були готові випробувати свою \"часову машину\". Вони налаштували м'яч на подорож до часів давнього Єгипту, де зустріли фараона та дізналися про життя стародавнього світу.");
    texts.add(
        "Оля і Петя вирішили стати шеф-кухарями і влаштовували \"кулінарні баталії\" вдома. Вони вивчили рецепти з різних країн та приготували м'ячі для своїх батьків.");
    texts.add(
        "Оля та Петя відкрили в старій скрині дивний м'яч, який переносить їх у часі. Вони відвідали різні епохи: стародавні Рим та середньовічну Європу, де зустріли лицарів та феодалів.");
    texts.add(
        "Оля і Петя взяли м'яч та вирушили досліджувати життя у річці, яка протікала через їхній ліс. Вони вивчили водяних комах, риб, та рослини і стали екологами.");
    texts.add(
        "Оля і Петя влаштували виставу для своїх друзів у лісі. Вони склали власний сценарій, придумали костюми з м'ячів і виконали свої ролі у виставі про пригоди у лісі.");
    texts.add(
        "Оля і Петя вирішили стати екологічними героями і прибирати м'ячі у лісі. Вони організували \"екологічний день\" зі своїми друзями і разом прибрали ліс від сміття, навчаючи всіх про важливість дбайливого ставлення до природи.");
    texts.add(
        "Оля і Петя відправилися у ліс у пошуках магічних пригод. Там вони знайшли м'яч, який вони уявили собі як ворота в казковий світ. Переступивши поріг, вони стали героями власної казки, де зустріли чарівних персонажів і вирішили небезпечну загадку.");
    texts.add(
        "Оля і Петя рішили влаштувати вечірку для інопланетян, які, за їхньою думкою, могли приземлитися в їх лісі. Вони прикрасили дерева м'ячем, придумали незвичайні імена для інопланетян і провели гру \"Знаходження інопланетного скарбу\". Ця історія навчає творчості та тому, як зробити будь-яку подію особливою.");
    texts.add(
        "Оля і Петя вирішили стати археологами на день. Завдяки своїй уяві, вони знайшли \"скриню з скарбами\" (м'яч) . Вони навіть створили власний \"музей\" і провели екскурсію для своїх батьків та друзів.");
    texts.add(
        "Оля і Петя вирішили дослідити космос. Вони взяли з собою м'яч. Забравшись на гору, вони \"злетіли\" на своєму кораблі і вивчили зорі та планети. Ця історія навчає, що навколишній світ завжди варто досліджувати.");
    texts.add(
        "Оля та Петя рішили створити власну \"школу\" під відкритим небом. Оля виступила вчителем, а Петя - студентом. Вони вивчали природу, знайшли цікавий м'яч, і навіть організували \"екскурсію\" по своєму лісі, де вчили один одного цікавим фактам і назвам рослин і тварин.");
    texts.add(
        "Одного разу Оля і Петя відвідали магазин товарів, і Петя звернув увагу на креативний м'яч з яскравими кольорами і нестандартною формою. Вони купили його і провели цілий день, граючи у парку, де всі захоплювалися їхнім яскравим м'ячем.");
    texts.add(
        "Оля і Петя вирішили провести літню відпустку у таборі для дітей. Там вони не тільки покращили свої навички, але й познайомилися з багатьма новими друзями. м'яч став символом цього незабутнього літа, і вони навіки згадували цей табір з радістю.");
    texts.add(
        "Оля і Петя вирішили провести день на березі озера. Оля приготувала смачний пікнік, а Петя взяв із собою мяч. Під час обіду вони вирішили влаштувати піратську гру на воді. Вони використали мяч як скарб і плавали на надувному матраці, намагаючись знайти \"скарб\". Ця пригода виявилася неймовірно веселою, і вони не тільки знайшли свій уявний скарб, але й створили незабутні спогади про свій піратський пригодницький день на озері.");

    System.out.println("  FFFFF   U   U  N   N  IIIII  N   N      A     TTTTT  OOO   RRRR ");
    System.out.println("  F       U   U  NN  N    I    NN  N     A A      T   O   O  R   R");
    System.out.println("  FFF     U   U  N N N    I    N N N    A   A     T   O   O  RRRR ");
    System.out.println("  F       U   U  N  NN    I    N  NN   AAAAAAA    T   O   O  R  R ");
    System.out.println("  F        UUU   N   N  IIIII  N   N  A       A   T    OOO   R   R\n");

  }
}