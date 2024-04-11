Feature: Verify the Job list page for Search funcitonality

  Scenario: Verify that Jobs can be searched using ID
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter 54 in the Seach bar
    Then Job with that ID is displayed in the results table

  Scenario: Verify that Jobs can be searched using JobID
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter post_558 in the Seach bar
    Then Job with that JobID is displayed in the results table

  Scenario: Verify that Jobs can be searched using Name
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter Name of the job again in the Seach bar
    Then Job with that name is displayed in the results table

  Scenario: Verify that Jobs can be searched using Status
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter failure in the Seach bar
    Then Job(s) with that status is/are displayed in the results table

  Scenario: Verify that Jobs can be searched using Operation
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter Update in the Seach bar
    Then Job(s) with that Operation is/are displayed in the results table

  Scenario: Verify that Jobs can be searched using Environment
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter Sandbox in the Seach bar
    Then Job(s) with that Environment is/are displayed in the results table


  Scenario: Verify that Jobs can be searched using Created Date
    Given I can navigate to the Joblist page
    And Search bar is displayed
    When I enter Oct 2, 2021 in the Seach bar
    Then Job(s) with that Date is/are displayed in the results table

    Scenario Outline: Verify that the Jobs list is Sorted when clicked on column names
      Given I can navigate to the Joblist page
      And Joblist table is displayed
      When I click on <column_name> column
      Then Jobs table is sorted in ascending order of <column_name>
      Examples:
        | column_name  |  |
        | ID           |  |
        | Name         |  |
        | Job ID       |  |
        | Status       |  |
        | Operation    |  |
        | Environment  |  |
        | Created Date |  |

  Scenario: Verify that the Jobs table is not displayed when there is no Match
        Given I can navigate to the Joblist page
        And Joblist table is displayed
        When I enter 2022 in the Seach bar
        Then Jobtable is displayed with no results