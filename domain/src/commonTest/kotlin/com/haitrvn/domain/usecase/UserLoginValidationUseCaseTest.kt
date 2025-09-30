package com.haitrvn.domain.usecase

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserLoginValidationUseCaseTest {

    private val useCase = UserLoginValidationUseCase()

    // ========== USERNAME VALIDATION TESTS ==========

    @Test
    fun `validateUserName - empty username should return Empty error`() = runTest {
        val result = useCase.validateUserName("")

        assertEquals(1, result.size)
        assertTrue(result.contains(UsernameValidationError.Empty))
    }

    @Test
    fun `validateUserName - username too short should return TooShort error`() = runTest {
        val result = useCase.validateUserName("ab")

        assertEquals(1, result.size)
        assertTrue(result.contains(UsernameValidationError.TooShort))
    }

    @Test
    fun `validateUserName - username too long should return TooLong error`() = runTest {
        val result = useCase.validateUserName("a".repeat(21))

        assertEquals(1, result.size)
        assertTrue(result.contains(UsernameValidationError.TooLong))
    }

    @Test
    fun `validateUserName - username with invalid characters should return InvalidCharacter error`() =
        runTest {
            val invalidUsernames = listOf(
                "user@name",
                "user#name",
                "user name",
                "user-name",
                "user+name"
            )

            invalidUsernames.forEach { username ->
                val result = useCase.validateUserName(username)
                assertTrue(
                    result.contains(UsernameValidationError.InvalidCharacter),
                    "Username '$username' should be invalid"
                )
            }
        }

    @Test
    fun `validateUserName - username starting with dot should return InvalidDotPosition error`() =
        runTest {
            val result = useCase.validateUserName(".username")

            assertTrue(result.contains(UsernameValidationError.InvalidDotPosition))
        }

    @Test
    fun `validateUserName - username ending with dot should return InvalidDotPosition error`() =
        runTest {
            val result = useCase.validateUserName("username.")

            assertTrue(result.contains(UsernameValidationError.InvalidDotPosition))
        }

    @Test
    fun `validateUserName - username with consecutive dots should return ConsecutiveDots error`() =
        runTest {
            val result = useCase.validateUserName("user..name")

            assertTrue(result.contains(UsernameValidationError.ConsecutiveDots))
        }

    @Test
    fun `validateUserName - valid usernames should return no errors`() = runTest {
        val validUsernames = listOf(
            "abc",
            "user123",
            "user_name",
            "user.name",
            "User123",
            "a".repeat(20), // max length
            "abc" // min length
        )

        validUsernames.forEach { username ->
            val result = useCase.validateUserName(username)
            assertTrue(
                result.isEmpty(),
                "Username '$username' should be valid but got errors: $result"
            )
        }
    }

    @Test
    fun `validateUserName - multiple errors should be returned`() = runTest {
        val result = useCase.validateUserName(".user@name.")

        assertTrue(result.contains(UsernameValidationError.InvalidCharacter))
        assertTrue(result.contains(UsernameValidationError.InvalidDotPosition))
        assertEquals(2, result.size)
    }

    // ========== PASSWORD VALIDATION TESTS ==========

    @Test
    fun `validatePassword - empty password should return Empty error`() = runTest {
        val result = useCase.validatePassword("")

        assertEquals(1, result.size)
        assertTrue(result.contains(PasswordValidationError.Empty))
    }

    @Test
    fun `validatePassword - password too short should return TooShort error`() = runTest {
        val result = useCase.validatePassword("Pass1!")

        assertEquals(1, result.size)
        assertTrue(result.contains(PasswordValidationError.TooShort))
    }

    @Test
    fun `validatePassword - password without digit should return NoDigit error`() = runTest {
        val result = useCase.validatePassword("Password!")

        assertTrue(result.contains(PasswordValidationError.NoDigit))
    }

    @Test
    fun `validatePassword - password without uppercase should return NoUppercase error`() =
        runTest {
            val result = useCase.validatePassword("password1!")

            assertTrue(result.contains(PasswordValidationError.NoUppercase))
        }

    @Test
    fun `validatePassword - password without special character should return NoSpecialCharacter error`() =
        runTest {
            val result = useCase.validatePassword("Password1")

            assertTrue(result.contains(PasswordValidationError.NoSpecialCharacter))
        }

    @Test
    fun `validatePassword - valid passwords should return no errors`() = runTest {
        val validPasswords = listOf(
            "Password1!",
            "MyPass123@",
            "SecureP4$$",
            "Test1234#",
            "Admin2024*"
        )

        validPasswords.forEach { password ->
            val result = useCase.validatePassword(password)
            assertTrue(
                result.isEmpty(),
                "Password '$password' should be valid but got errors: $result"
            )
        }
    }

    @Test
    fun `validatePassword - multiple errors should be returned`() = runTest {
        val result = useCase.validatePassword("pass")

        assertTrue(result.contains(PasswordValidationError.TooShort))
        assertTrue(result.contains(PasswordValidationError.NoDigit))
        assertTrue(result.contains(PasswordValidationError.NoUppercase))
        assertTrue(result.contains(PasswordValidationError.NoSpecialCharacter))
        assertEquals(4, result.size)
    }

    @Test
    fun `validatePassword - password with all requirements except length should return TooShort only`() =
        runTest {
            val result = useCase.validatePassword("Pass1!")

            assertEquals(1, result.size)
            assertTrue(result.contains(PasswordValidationError.TooShort))
        }

    @Test
    fun `validatePassword - long password missing requirements should return specific errors`() =
        runTest {
            val result = useCase.validatePassword("passwordwithoutuppercase")

            assertTrue(result.contains(PasswordValidationError.NoDigit))
            assertTrue(result.contains(PasswordValidationError.NoUppercase))
            assertTrue(result.contains(PasswordValidationError.NoSpecialCharacter))
            assertEquals(3, result.size)
        }

    // ========== EDGE CASES ==========

    @Test
    fun `validateUserName - boundary length cases`() = runTest {
        // Exactly min length (3)
        val minResult = useCase.validateUserName("abc")
        assertTrue(minResult.isEmpty())

        // Exactly max length (20)
        val maxResult = useCase.validateUserName("a".repeat(20))
        assertTrue(maxResult.isEmpty())

        // One below min (2)
        val belowMinResult = useCase.validateUserName("ab")
        assertTrue(belowMinResult.contains(UsernameValidationError.TooShort))

        // One above max (21)
        val aboveMaxResult = useCase.validateUserName("a".repeat(21))
        assertTrue(aboveMaxResult.contains(UsernameValidationError.TooLong))
    }

    @Test
    fun `validatePassword - boundary length cases`() = runTest {
        // Exactly min length (8) with all requirements
        val minResult = useCase.validatePassword("Pass123!")
        assertTrue(minResult.isEmpty())

        // One below min (7) with all requirements
        val belowMinResult = useCase.validatePassword("Pass12!")
        assertTrue(belowMinResult.contains(PasswordValidationError.TooShort))
    }

    @Test
    fun `validateUserName - special dot cases`() = runTest {
        // Valid single dot in middle
        val validDot = useCase.validateUserName("user.name")
        assertTrue(validDot.isEmpty())

        // Multiple non-consecutive dots
        val multipleDots = useCase.validateUserName("user.name.test")
        assertTrue(multipleDots.isEmpty())

        // Triple consecutive dots
        val tripleDots = useCase.validateUserName("user...name")
        assertTrue(tripleDots.contains(UsernameValidationError.ConsecutiveDots))
    }
}