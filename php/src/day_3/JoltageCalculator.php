<?php

declare(strict_types=1);

namespace App\day_3;

class JoltageCalculator {

    public function calculate(string $input): int {
        $lines = explode("\n", $input);

        $sum = 0;

        foreach($lines as $line) {
            $array = str_split($line);

            $tensIndex = 0;
            $tens = 0;
            $ones = 0;

            foreach($array as $index => $char) {
                $number = (int)$char;

                if ($number > $tens and $index < strlen($line) - 1) {
                    $tens = $number;
                    $tensIndex = $index;
                    $ones = 0;
                }

                if ($number > $ones and $index > $tensIndex) {
                    $ones = $number;
                }
            }

            $sum += (int) "$tens$ones";
        }

        return $sum;
    }
}

$input = file_get_contents("src/day_3/input");

$calculator = new JoltageCalculator();

echo $calculator->calculate($input);