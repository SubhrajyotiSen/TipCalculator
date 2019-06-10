/*
 * Copyright (c) 2019 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish, 
 * distribute, sublicense, create a derivative work, and/or sell copies of the 
 * Software in any work that is designed, intended, or marketed for pedagogical or 
 * instructional purposes related to programming, coding, application development, 
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works, 
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.tipcalculator

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.raywenderlich.android.tipcalculator.model.BillModel
import com.raywenderlich.android.tipcalculator.viewmodel.TipCalculatorViewModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TipCalculatorViewModelTest {

  @get:Rule
  val rule = InstantTaskExecutorRule()

  private lateinit var tipCalculatorViewModel: TipCalculatorViewModel

  @Before
  fun setup() {
	tipCalculatorViewModel = TipCalculatorViewModel()
  }

  @Test
  fun testViewModel() {
	tipCalculatorViewModel.billAmount = "100.0"
	tipCalculatorViewModel.tipPercentage = "25"
	tipCalculatorViewModel.numberOfPeople = "5"

	tipCalculatorViewModel.calculateTip()

	val bill = BillModel(25.0, 125.0, 25.0)

	assertEquals(tipCalculatorViewModel.calculatedBill.value, bill)

  }
}