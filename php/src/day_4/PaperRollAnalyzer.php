<?php

declare(strict_types=1);

namespace App\day_4;

class PaperRollAnalyzer {

    public function analyze(array $input): int {
        $map = [];
        $row = 0;
        $sum = 0;
        $parsed = 0;

        while ($row < count($input)) {
            if (isset($input[$parsed])) {
                $map[] = str_split($input[$parsed]);
                $parsed++;
            }

            if (count($map) > 1) {
                foreach ($map[$row] as $col => $char) {
                    if ($char === '@') {
                        if ($this->checkAdjacent($map, $row, $col)) {
                            $sum++;
                        }
                    }
                }
                $row++;
            }
        }

        return $sum;
    }
    
    public function checkAdjacent(array $map, int $row, int $col): bool {
        $positions = [
            [$row-1, $col-1],
            [$row-1, $col],
            [$row-1, $col+1],
            [$row, $col+1],
            [$row, $col-1],
            [$row+1, $col-1],
            [$row+1, $col],
            [$row+1, $col+1],
        ];

        $num = 0;

        foreach ($positions as $position) {
            if (isset($map[$position[0]][$position[1]]) and $map[$position[0]][$position[1]] === '@') {
                $num += 1;
                if ($num > 3) {
                    return false;
                }
            }
        }
        return true;
    }
}

$string = file_get_contents("src/day_4/input");

$array = explode("\n", $string);

foreach ($array as $line) {
    echo $line;

}