////////////////////////////////////////////////////////////////////////
// Course: ITM-510-05                                                 //
// Assignment: Balanced (grouping) symbols                            //
// Date: 10/11/2023                                                   //
// Student: Hendra Wijaya (A20529195)                                 //
//                                                                    //
// Application that shows whether grouping symbols imported from a    //
// text file are balanced.                                            //
////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * An object that determines whether grouping symbols are balanced and provides step-by-step
 * progress along the way. The valid parentheses symbols are: standard parentheses {@code ()}, curly
 * braces {@code {}}, square brackets {@code []}, and angle brackets {@code <>}.
 */
public class GroupingSymbols {
  private static final Map<Character, Character> VALID_SYMBOLS = new HashMap<>();

  static {
    VALID_SYMBOLS.put(')', '(');
    VALID_SYMBOLS.put('}', '{');
    VALID_SYMBOLS.put(']', '[');
    VALID_SYMBOLS.put('>', '<');
  }

  private final String text;
  private final Stack<Character> stack = new Stack<>();
  private final StringBuilder steps = new StringBuilder();
  public final List<String> stackSteps = new ArrayList<>();

  /**
   * Constructs a new grouping symbols object from a text.
   */
  public GroupingSymbols(String text) {
    this.text = text;
    int stepIndex = 0;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (!VALID_SYMBOLS.containsKey(c) && !VALID_SYMBOLS.containsValue(c)) {
        steps.append(String.format("%d. Ignore %s", ++stepIndex, getHighlightedText(text, i)))
            .append('\n');
        stackSteps.add(String.format("%d. %s", stepIndex, getStackText(stack)));
        continue;
      }
      if (!VALID_SYMBOLS.containsKey(c)) {
        stack.push(c);
        steps.append(String.format("%d. Push %s", ++stepIndex, getHighlightedText(text, i)))
            .append('\n');
        stackSteps.add(String.format("%d. %s → %s", stepIndex, c, getStackText(stack)));
        continue;
      }
      if (stack.isEmpty() || stack.peek() != VALID_SYMBOLS.get(c)) {
        steps.append(String.format("%d. Fail %s", ++stepIndex, getHighlightedText(text, i)))
            .append('\n');
        stackSteps.add(String.format("%d. %s", stepIndex, getStackText(stack)));
        return;
      }
      stack.pop();
      steps.append(String.format("%d. Pop %s", ++stepIndex, getHighlightedText(text, i)))
          .append('\n');
      stackSteps.add(String.format("%d. %s ← %s",
          stepIndex, VALID_SYMBOLS.get(c), getStackText(stack)));
    }
  }

  /**
   * Returns true if the grouping symbols are balanced.
   */
  public boolean isBalanced() {
    if (text.isEmpty()) {
      return true;
    }
    return stack.isEmpty();
  }

  @Override
  public String toString() {
    return "Input text:" + '\n'
        + text + "\n\n"
        + "Steps:" + "\n"
        + steps + "\n"
        + (isBalanced() ? "Symbols are balanced." : "Unbalanced grouping symbols!");
  }

  private static String getHighlightedText(String text, int highlight) {
    return String.format("%s'%s'%s",
        text.substring(0, highlight), text.charAt(highlight), text.substring(highlight + 1));
  }

  private static String getStackText(Stack<?> stack) {
    if (stack.isEmpty()) {
      return "Empty";
    }
    return stack.stream().map(String::valueOf).collect(Collectors.joining());
  }
}
