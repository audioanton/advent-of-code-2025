import unittest

from day_5.ingredient_id_validator import IngredientIdValidator


class MyTestCase(unittest.TestCase):

    def test_get_min_max(self):
        validator = IngredientIdValidator()
        mylist = ["10-14", "16-20"]

        expected = [[10, 14], [16, 20]]

        got = validator.get_min_max(mylist)

        self.assertEqual(expected, got)

    def test_to_numbers(self):
        ingredient_id_validator = IngredientIdValidator()

        expected = [1,2,34]

        got = ingredient_id_validator.to_numbers(["1", "2", "34"])
        self.assertEqual(expected, got)

    def test_splits(self):
        validator = IngredientIdValidator()
        expected = [
"""3-5
10-14
16-20
12-18""",
"""1
5
8
11
17
32"""]

        got = validator.split_ranges_ids("""3-5
10-14
16-20
12-18

1
5
8
11
17
32""")

        self.assertEqual(expected, got)

    def test_validate(self):

        validator = IngredientIdValidator()
        result = validator.validate("""3-5
10-14
16-20
12-18

1
5
8
11
17
32""")

        self.assertEqual(result, 3)

    def test_splits_ids(self):
        validator = IngredientIdValidator()

        result = validator.splits_ids("""1
5
8
11
17
32""")

        self.assertEqual(result, ["1", "5", "8", "11", "17", "32"])


if __name__ == '__main__':
    unittest.main()
