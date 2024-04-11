Feature: Add new Posts

  Scenario: Verify that Posts can be added
    Given There are Posts
    When I create a new post
    Then the Post is created

  Scenario: Verify that Posts can be modified
    Given There are Posts
    When I update a post with id "dd48" and 400 views
    Then the Post is updated

  Scenario Outline: Verify that Posts can be added using Examples
    Given There are Posts
    When I create a new post with <title> and <views>
    Then the Post with <title> is created
    Examples:
      | title                   | views |
      | "how to create posts 1" | 1000  |
      | "how to create posts 2" | 2000  |
      | "how to create posts 3" | 3000  |
      | "how to create posts 4" | 4000  |
      | "how to create posts 5" | 5000  |
      | "how to create posts 6" | 6000  |
      | "how to create posts 7" | 7000  |
      | "how to create posts 8" | 8000  |

  Scenario: Verify that Posts can be added using Datatables
    Given There are Posts
    When I create a new post with the following:
      | how to create posts 2 | 2000 |
      | how to create posts 1 | 1000 |
      | how to create posts 3 | 3000 |
      | how to create posts 4 | 4000 |
      | how to create posts 5 | 5000 |
      | how to create posts 6 | 6000 |
      | how to create posts 7 | 7000 |
      | how to create posts 8 | 8000 |
    Then the Post with given titles is created


  Scenario: Verify that Posts can be added using Datatables
    Given There are Posts
    When I create a new post with the following table:
      | title                   | views |
      | "how to create posts 1" | 1000  |
      | "how to create posts 2" | 2000  |
      | "how to create posts 3" | 3000  |
      | "how to create posts 4" | 4000  |
      | "how to create posts 5" | 5000  |
      | "how to create posts 6" | 6000  |
      | "how to create posts 7" | 7000  |
      | "how to create posts 8" | 8000  |
    Then the Post with given titles is created
