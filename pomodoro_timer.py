import time
import os

# Function to send a notification
def notify(title, message):
    os.system(f'notify-send "{title}" "{message}"')

# Function to run the Pomodoro timer
def pomodoro_timer(work_time=25, break_time=5, cycles=4):
    for cycle in range(1, cycles + 1):
        print(f"\nPomodoro {cycle}: Work for {work_time} minutes!")
        notify("Pomodoro Timer", f"Cycle {cycle}: Work for {work_time} minutes!")
        countdown(work_time * 60)

        print("\nTime for a break!")
        notify("Break Time!", f"Take a {break_time}-minute break!")
        countdown(break_time * 60)

    print("\nPomodoro session completed! 🎉")
    notify("Pomodoro Completed", "Well done! You’ve finished your session!")

# Function to display countdown timer
def countdown(seconds):
    while seconds:
        mins, secs = divmod(seconds, 60)
        timer_display = f"{mins:02d}:{secs:02d}"
        print(f"\r{timer_display}", end="", flush=True)
        time.sleep(1)
        seconds -= 1
    print("\r00:00", flush=True)

if __name__ == "__main__":
    pomodoro_timer()
