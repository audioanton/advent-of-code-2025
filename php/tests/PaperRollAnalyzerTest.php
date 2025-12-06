<?php

declare(strict_types=1);

namespace Tests;

use App\day_4\PaperRollAnalyzer;


describe('PaperRollAnalyzer', function () {
    it('returns 5', function () {
        $analyzer = new PaperRollAnalyzer();
        $result = $analyzer->analyze(['..@@.@@@@.', '@@@.@.@.@@']);
        expect($result)->toBe(5);
    });

    it('returns 13', function () {
        $analyzer = new PaperRollAnalyzer();

        $result = $analyzer->analyze([
            "..@@.@@@@.",
            "@@@.@.@.@@",
            "@@@@@.@.@@",
            "@.@@@@..@.",
            "@@.@@@@.@@",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "@.@@@.@@@@",
            ".@@@@@@@@.",
            "@.@.@@@.@."
          ]
        );

        expect($result)->toBe(13);
    });
});