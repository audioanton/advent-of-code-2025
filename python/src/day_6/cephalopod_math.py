import re


class CephalopodMath:

    def columnize(self, input):
        rows = input.split('\n')

        columns = []

        for row in rows:
            split = [col for col in re.split(r"\s+", row) if col != '']
            for index, column in enumerate(split):
                columns[index].append(column) if index < len(columns) else columns.append([column])

        return columns

    def calculate(self, problems):
        result = 0

        for problem in problems:
            solution = 0
            operator = problem.pop(-1)

            for number in problem:
                if operator == '+':
                    solution += int(number)
                    continue
                solution = solution * int(number) if solution > 0 else int(number)

            result += solution

        return result

if __name__ == '__main__':
    cephalopod_math = CephalopodMath()

    with open('src/day_6/input', 'r') as file:
        print(cephalopod_math.calculate(cephalopod_math.columnize(file.read())))