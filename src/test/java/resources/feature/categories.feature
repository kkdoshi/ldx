Feature: Categories Functionality
  Testing the Categories functionality by performing end to end CRUD operation

  Scenario: I should be able to create a new category successfully
    When I create a new category
    And I extract the ID of the newly created category
    Then I verifies the new category has been created successfully by ID

  Scenario: I should be able to read the newly created category successfully
    When I read the newly created category by ID
    Then I verify the new category has been created successfully
#    And I ensure no duplicate records have been created
#    And I ensure that the new category name has no spelling errors
#
#  Scenario: I should be able to update the newly created category
#    When I update the newly created category "Updated Name"
#    Then I should verify that the update has been performed successfully
#    And I ensure that the updated category name has no spelling errors
#
#  Scenario: I should be able to delete the newly created ID successfully
#    When I delete the newly created category by ID
#    Then I should verify that the deletion has been performed successfully









#    Given User extracts a list of existing ID's before creating a new record
#    When  User creates a new booking using the correct details "<lastname>" "<totalprice>""<depositpaid>" "<additionalneeds>"
#    And User verifies the new booking has been created successfully
#    And User updates the created record by updating the firstname "<lastname>" "<totalprice>""<depositpaid>" "<additionalneeds>"
#    And User verifies that the record has been updated successfully
#    And User deletes the newly created record by providing the booking id
#    Then User verifies that the record has been deleted successfully
#    Examples:
#      | lastname | totalprice | depositpaid | additionalneeds   |
#      | Smith    | 500        | true        | Vegetarian Food   |
#      | King     | 1000       | false       | Bed and Breakfast |