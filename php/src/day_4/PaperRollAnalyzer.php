<?php

declare(strict_types=1);

namespace App\day_4;

class PaperRollAnalyzer {

    public function analyze(array $input): int {
        $map = [];
        $row = 0;

        foreach ($input as $index => $line) {
            $map[$row] = $this->parse($line);
            
            if (count($map) > 1) {
                foreach ($map[$row] as $col => $char) {
                    if ($char !== '.') {
                        $this->checkAdjacent($map, $row, $col);
                    }
                }
            }
            $row++;
        }

        return 0;
    }
    
    public function checkAdjacent(array $map, int $row, int $col): void {
        $directions = [
            [-1, 0], // Up
            [1, 0],  // Down
            [0, -1], // Left
            [0, 1],  // Right
        ];

        foreach ($directions as [$dRow, $dCol]) {
            $newRow = $row + $dRow;
            $newCol = $col + $dCol;

            if (isset($map[$newRow][$newCol]) && $map[$newRow][$newCol] === '@') {
                // Found an adjacent '@'
            }
        }
    }

    public function parse(string $line): array {
        return str_split($line);
    }
}