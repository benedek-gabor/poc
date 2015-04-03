Feature: Proof of concept for Links

  Scenario Outline: Test with examples and outline
    Given The person: <Subjective>
    When <Subjective> <Verb> <Adjective>
    Then going to be <Something>

    Examples: 
      | Subjective | Verb   | Adjective         | Something         |
      | Gabor      | learns | BDD               | more professional |
      | You        | are    | reading this code | more experienced  |
      | Lisa       | is     | pretty            | happier           |
      | Peter      | is     | confident         | brave             |
