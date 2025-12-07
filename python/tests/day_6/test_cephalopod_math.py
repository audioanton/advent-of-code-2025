from unittest import TestCase, skip

from day_6.cephalopod_math import CephalopodMath


class TestCephalopodMath(TestCase):
    def setUp(self):
        self.input = """123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   + """

        self.columnized = [
            ['123', '45', '6', '*'],
            ['328', '64', '98', '+'],
            ['51', '387', '215', '*'],
            ['64', '23', '314', '+']
        ]

        self.cephalopod_math = CephalopodMath()

    def test_columnize(self):
        got = self.cephalopod_math.columnize(self.input)

        self.assertEqual(got, self.columnized)

    def test_calculate(self):
        got = self.cephalopod_math.calculate(self.columnized)

        self.assertEqual(4277556, got)
