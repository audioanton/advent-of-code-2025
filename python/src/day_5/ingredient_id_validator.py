import re

class IngredientIdValidator:

    def split_ranges_ids(self, input):
        return re.split(r"\n\n", input)

    def to_numbers(self, ids):
        return [int(ingredient_id) for ingredient_id in ids]

    def get_min_max(self, ranges):
        split = [range.split("-") for range in ranges]
        return [[int(a), int(b)] for a, b in split]

    def validate(self, id_string):
        count = 0

        range_string, id_string = self.split_ranges_ids(id_string)

        ranges = self.get_min_max(range_string.split("\n"))

        ids = [int(ingredient_id) for ingredient_id in id_string.strip().split("\n")]

        for ingredient_id in ids:
            ranges_with_id = filter(lambda filtered: filtered[0] <= ingredient_id <= filtered[1], ranges)
            if len(list(ranges_with_id)) > 0:
                count += 1

        return count


if __name__ == '__main__':
    validator = IngredientIdValidator()

    with open('src/day_5/input', 'r') as file:
        print(validator.validate(file.read()))