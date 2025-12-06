<?php

declare(strict_types=1);

namespace Tests\day_3;

use App\day_3\JoltageCalculator;

describe("Joltage Calculator", function () {
    it("returns 357", function () {
       $calculator = new JoltageCalculator();

       $input = <<<END
        987654321111111
        811111111111119
        234234234234278
        818181911112111
        END;

       $result = $calculator->calculate($input);

       expect($result)->toBe(357);
    });
});